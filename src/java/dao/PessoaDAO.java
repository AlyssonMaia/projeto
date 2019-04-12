package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;

public class PessoaDAO {
    
    public static int idLog;
    
    private static Connection conexao;
    private static PreparedStatement preSta;
    private static ResultSet resSet;
    
    private static final Logger LOG = Logger.getLogger(PessoaDAO.class.getName());
    
    public static synchronized void Create(Pessoa pessoa) {
        
        conexao = ConnectionFactory.getConnection();
        preSta = null;
        resSet = null;
        
        StringBuilder insert = new StringBuilder();
        
        try {
            
            insert.append("INSERT INTO ");
            insert.append("pessoa( ");
            insert.append("nome, ");
            insert.append("cpf, ");
            insert.append("end, ");
            insert.append("email, ");
            insert.append("telefone, ");
            insert.append("tipo, ");
            insert.append("ativo");
                
            if(pessoa.isCargo().equals("DIRETOR")){
                
                insert.append(", titulacao) ");
                insert.append("VALUES ");
                insert.append("(?,?,?,?,?,?,?,?); ");
            
            }else{
            
                insert.append(") VALUES ");
                insert.append("(?,?,?,?,?,?,?); ");
            
            }
            
            preSta = conexao.prepareStatement(insert.toString(), 
                     PreparedStatement.RETURN_GENERATED_KEYS);
            
            preSta.setString(1, pessoa.getNome());
            preSta.setString(2, pessoa.getCpf());
            preSta.setString(3, pessoa.getEndereco());
            preSta.setString(4, pessoa.getEmail());
            preSta.setString(5, pessoa.getTelefone());
            preSta.setString(6, pessoa.getTipo());
            preSta.setBoolean(7, pessoa.isAtivo());
            
            if(pessoa.isCargo().equals("DIRETOR")){
            
                preSta.setString(8, pessoa.getTitulacao());
            
            }
            
            preSta.executeUpdate();
           
            LOG.info(pessoa.isConfirmacaoCreate());
            
            resSet = preSta.getGeneratedKeys();
            resSet.next();
            idLog = resSet.getInt(1);
            
        } catch (SQLException ex) {
            
            LOG.log(Level.SEVERE, "Erro de DataBase e SQL INSERT", ex);
            
        } finally {
            
            ConnectionFactory.closeConnectionResult(conexao, preSta, resSet);
            
        }
        
    }

    public static synchronized List<Pessoa> Read(String tipo) {
        
        conexao = ConnectionFactory.getConnection();
        preSta = null;
        resSet = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        StringBuilder select = new StringBuilder();
        
        try {
            
            select.append("SELECT ");
            select.append("id, ");
            select.append("nome, ");
            select.append("cpf, ");
            select.append("end, ");
            select.append("email, ");
            select.append("telefone, ");
            select.append("tipo, ");
            select.append("ativo ");
            
            if(tipo.equals("DIRETOR")){
                
                select.append(", titulacao ");
            
            }
            
            select.append("FROM pessoa ");
            select.append("WHERE tipo = '");
            select.append(tipo);
            select.append("' AND ativo = TRUE ");
            select.append("ORDER BY nome; ");
            
            preSta = conexao.prepareStatement(select.toString());
            resSet = preSta.executeQuery();
            
            while (resSet.next()) {
            
                Pessoa pessoa = new Pessoa();
                
                pessoa.setId(resSet.getInt("id"));
                pessoa.setNome(resSet.getString("nome"));
                pessoa.setCpf(resSet.getString("cpf"));
                pessoa.setEndereco(resSet.getString("end"));
                pessoa.setEmail(resSet.getString("email"));
                pessoa.setTelefone(resSet.getString("telefone"));
                pessoa.setTipo(resSet.getString("tipo"));
                pessoa.setAtivo(resSet.getBoolean("ativo"));
             
                if(pessoa.isCargo().equals("DIRETOR")){
                    
                    pessoa.setTitulacao(resSet.getString("titulacao"));
                
                }
                
                pessoas.add(pessoa);
            
            }
            
        } catch (SQLException ex) {
            
            LOG.log(Level.SEVERE, "Erro de DataBase e SQL SELECT", ex);
            
        } finally {
            
            ConnectionFactory.closeConnectionResult(conexao, preSta, resSet);
            
        }
                
        return pessoas;
    
    }
    
        public static synchronized Pessoa Read(Pessoa pessoa) {
        
        conexao = ConnectionFactory.getConnection();
        preSta = null;
        resSet = null;
        
        Pessoa pessoas = new Pessoa();
        StringBuilder select = new StringBuilder();
        
        try {
            
            select.append("SELECT ");
            select.append("id, ");
            select.append("nome, ");
            select.append("cpf, ");
            select.append("end, ");
            select.append("email, ");
            select.append("telefone, ");
            select.append("tipo, ");
            select.append("ativo ");
            
            if(pessoa.getTipo().equals("DIRETOR")){
                
                select.append(", titulacao ");
            
            }
            
            select.append("FROM pessoa ");
            select.append("WHERE tipo = '");
            select.append(pessoa.getTipo());
            select.append("' AND id = ");
            select.append(pessoa.getId());
            select.append(" AND ativo = TRUE ");
            
            preSta = conexao.prepareStatement(select.toString());
            resSet = preSta.executeQuery();
            
            if (resSet.next()) {
            
                pessoas.setId(resSet.getInt("id"));
                pessoas.setNome(resSet.getString("nome"));
                pessoas.setCpf(resSet.getString("cpf"));
                pessoas.setEndereco(resSet.getString("end"));
                pessoas.setEmail(resSet.getString("email"));
                pessoas.setTelefone(resSet.getString("telefone"));
                pessoas.setTipo(resSet.getString("tipo"));
                pessoas.setAtivo(resSet.getBoolean("ativo"));
             
                if(pessoas.isCargo().equals("DIRETOR")){
                    
                    pessoas.setTitulacao(resSet.getString("titulacao"));
                
                }
            
            }
            
        } catch (SQLException ex) {
            
            LOG.log(Level.SEVERE, "Erro de DataBase e SQL SELECT", ex);
            
        } finally {
            
            ConnectionFactory.closeConnectionResult(conexao, preSta, resSet);
            
        }
        
        LOG.info(pessoas.isConfirmacaoRead());
        
        return pessoas;
    
    }
        
    public static synchronized void Update(Pessoa pessoa) {
        
        conexao = ConnectionFactory.getConnection();
        preSta = null;
        
        StringBuilder update = new StringBuilder();
        
        try {
            
            update.append("UPDATE pessoa SET ");
            update.append("nome = ?, ");
            update.append("cpf = ?, ");
            update.append("end = ?, ");
            update.append("email = ?, ");
            update.append("telefone = ? ");
            
            if(pessoa.isCargo().equals("DIRETOR")){
            
                update.append(", titulacao = ? ");
            
            }
            
            update.append("WHERE id = ? ");
            update.append("AND ");
            update.append("tipo = '");
            update.append(pessoa.isCargo());
            update.append("' AND ");
            update.append("ativo = TRUE; ");
            
            preSta = conexao.prepareStatement(update.toString());
            
            preSta.setString(1, pessoa.getNome());
            preSta.setString(2, pessoa.getCpf());
            preSta.setString(3, pessoa.getEndereco());
            preSta.setString(4, pessoa.getEmail());
            preSta.setString(5, pessoa.getTelefone());
            
            if(pessoa.isCargo().equals("DIRETOR")){
            
                preSta.setString(6, pessoa.getTitulacao());
                preSta.setInt(7, pessoa.getId());
            
            }else{
            
                preSta.setInt(6, pessoa.getId());
            
            }
            
            preSta.executeUpdate();
            
            LOG.info(pessoa.isConfirmacaoUpdate());
            
        } catch (SQLException ex) {
            
            LOG.log(Level.SEVERE, "Erro de DataBase e SQL UPDATE", ex);
        
        } finally {
            
            ConnectionFactory.closeConnectionStatement(conexao, preSta);
        
        }
        
    }

    public static synchronized void Delete(Pessoa pessoa) {
        
        conexao = ConnectionFactory.getConnection();
        preSta = null;
        
        StringBuilder delete = new StringBuilder();
        
        try {
            
            delete.append("UPDATE pessoa ");
            delete.append("SET ativo = FALSE ");
            delete.append("WHERE id = ? ");
            delete.append("AND ");
            delete.append("ativo = '");
            delete.append(pessoa.isCargo());
            delete.append("'; ");
            
            preSta = conexao.prepareStatement(delete.toString());
            
            preSta.setInt(1, pessoa.getId());
            
            preSta.executeUpdate();
            
            LOG.info(pessoa.isConfirmacaoDelete());
            
            LoginDAO.Delete(pessoa.getId());
        
        } catch (SQLException ex) {
            
            LOG.log(Level.SEVERE, "Erro de DataBase e SQL DELETE", ex);
            
        } finally {
            
            ConnectionFactory.closeConnectionStatement(conexao, preSta);
        
        }
        
    }
    
    public static synchronized void Delete(int id) {
        
        conexao = ConnectionFactory.getConnection();
        preSta = null;
        
        StringBuilder delete = new StringBuilder();
        
        try {
            
            delete.append("UPDATE pessoa ");
            delete.append("SET ativo = FALSE ");
            delete.append("WHERE id = ");
            delete.append(id);
            
            preSta = conexao.prepareStatement(delete.toString());
            
            preSta.executeUpdate();           
            
            LoginDAO.Delete(id);
        
        } catch (SQLException ex) {
            
            LOG.log(Level.SEVERE, "Erro de DataBase e SQL DELETE", ex);
            
        } finally {
            
            ConnectionFactory.closeConnectionStatement(conexao, preSta);
        
        }
        
    }
}