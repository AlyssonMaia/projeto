package dao;

import connection.ConnectionFactory;
import graduacao.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CursoDAO {
    
    private static Connection conexao;
    private static PreparedStatement preSta;
    private static ResultSet resSet;
    
    private static final Logger LOG = Logger.getLogger(CursoDAO.class.getName());
    
    public static synchronized void Create(Curso pessoa) {
        
        conexao = ConnectionFactory.getConnection();
        preSta = null;
        
        StringBuilder insert = new StringBuilder();
        
        try {
            
            insert.append("INSERT INTO ");
            insert.append("curso( ");
            insert.append("nome, ");
            insert.append("area, ");
            insert.append("ativo) ");
            insert.append("VALUES ");
            insert.append("(?,?,?); ");
            
            preSta = conexao.prepareStatement(insert.toString());
            
            preSta.setString(1, pessoa.getNome());
            preSta.setString(2, pessoa.getArea());
            preSta.setBoolean(3, pessoa.isAtivo());
            
            preSta.executeUpdate();
           
            LOG.info("Curso cadastrado com sucesso!");
                        
        } catch (SQLException ex) {
            
            LOG.log(Level.SEVERE, "Erro de DataBase e SQL INSERT", ex);
            
        } finally {
            
            ConnectionFactory.closeConnectionStatement(conexao, preSta);
            
        }
        
    }
    
}