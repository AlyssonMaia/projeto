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
import model.Login;
import model.Pessoa;

public class LoginDAO {

    private static Connection conexao;
    private static PreparedStatement preSta;
    private static ResultSet resSet;

    private static final Logger LOG = Logger.getLogger(LoginDAO.class.getName());

    public static synchronized boolean authentication(String matricula, String senha) {

        conexao = ConnectionFactory.getConnection();
        preSta = null;
        resSet = null;

        Login user = new Login();
        StringBuilder authentication = new StringBuilder();

        try {

            authentication.append("SELECT ");
            authentication.append("* ");
            authentication.append("FROM ");
            authentication.append("login ");
            authentication.append("WHERE ");
            authentication.append("matricula = '");
            authentication.append(matricula);
            authentication.append("' AND ");
            authentication.append("senha = '");
            authentication.append(senha);
            authentication.append("'; ");

            preSta = conexao.prepareStatement(authentication.toString());
            resSet = preSta.executeQuery();

            if (resSet.next()) {

                user.setMatricula(resSet.getString("matricula"));
                user.setSenha(resSet.getString("senha"));
                user.setAtivo(resSet.getBoolean("ativo"));
                user.setIdPessoa(resSet.getInt("pessoa_id"));

            }

            if (user.getMatricula() != null && user.getSenha() != null) {

                return user.getMatricula().equals(matricula) && 
                       user.getSenha().equals(senha) && 
                       user.isAtivo()== true;

            }

        } catch (SQLException ex) {

            LOG.log(Level.SEVERE, "Erro de DataBase e SQL AUTHENTICATION", ex);

        } finally {

            ConnectionFactory.closeConnectionResult(conexao, preSta, resSet);

        }

        return false;

    }

    public static synchronized Pessoa userAuthentication(String matricula, String senha) {

        Pessoa user = null;

        if (authentication(matricula, senha) == true) {

            conexao = ConnectionFactory.getConnection();
            preSta = null;
            resSet = null;

            user = new Pessoa();
            StringBuilder login = new StringBuilder();

            try {

                login.append("SELECT ");
                login.append("P.id, ");
                login.append("P.nome, ");
                login.append("P.tipo ");
                login.append("FROM ");
                login.append("pessoa ");
                login.append("AS P ");
                login.append("INNER JOIN ");
                login.append("login ");
                login.append("AS L ON ");
                login.append("P.id = L.pessoa_id ");
                login.append("WHERE ");
                login.append("L.matricula = '");
                login.append(matricula);
                login.append("' AND ");
                login.append("L.senha = '");
                login.append(senha);
                login.append("' ; ");

                preSta = conexao.prepareStatement(login.toString());
                resSet = preSta.executeQuery();

                if (resSet.next()) {

                    user.setId(resSet.getInt("P.id"));
                    user.setNome(resSet.getString("P.nome"));
                    user.setTipo(resSet.getString("P.tipo"));

                }

            } catch (SQLException ex) {

                LOG.log(Level.SEVERE, "Erro de DataBase e SQL USER AUTHENTICATION", ex);

            } finally {

                LOG.info("Log In realizado com sucesso!");
                ConnectionFactory.closeConnectionResult(conexao, preSta, resSet);

            }

        }

        return user;

    }

    public static synchronized void Create(Login user) {

        conexao = ConnectionFactory.getConnection();
        preSta = null;

        StringBuilder insert = new StringBuilder();

        try {

            insert.append("INSERT INTO ");
            insert.append("login( ");
            insert.append("matricula, ");
            insert.append("senha, ");
            insert.append("pessoa_id, ");
            insert.append("ativo) ");
            insert.append("VALUES ");
            insert.append("(?,?,?,?); ");

            preSta = conexao.prepareStatement(insert.toString());

            preSta.setString(1, user.getMatricula());
            preSta.setString(2, user.getSenha());
            preSta.setInt(3, user.getIdPessoa());
            preSta.setBoolean(4, user.isAtivo());

            preSta.executeUpdate();

            LOG.info("Cadastro efetuado com sucesso!");

        } catch (SQLException ex) {

            LOG.log(Level.SEVERE, "Erro de DataBase e SQL INSERT", ex);

        } finally {

            ConnectionFactory.closeConnectionStatement(conexao, preSta);

        }

    }

    public static synchronized List<Login> Read() {

        conexao = ConnectionFactory.getConnection();
        preSta = null;
        resSet = null;

        List<Login> users = new ArrayList<>();
        StringBuilder select = new StringBuilder();

        try {

            select.append("SELECT ");
            select.append("matricula, ");
            select.append("senha, ");
            select.append("pessoa_id, ");
            select.append("ativo ");
            select.append("FROM login ");
            select.append("WHERE status = TRUE ");
            select.append("ORDER BY matricula; ");

            preSta = conexao.prepareStatement(select.toString());
            resSet = preSta.executeQuery();

            while (resSet.next()) {

                Login user = new Login();

                user.setMatricula(resSet.getString("matricula"));
                user.setSenha(resSet.getString("senha"));
                user.setIdPessoa(resSet.getInt("pessoa_id"));
                user.setAtivo(resSet.getBoolean("ativo"));

                users.add(user);

            }

        } catch (SQLException ex) {

            LOG.log(Level.SEVERE, "Erro de DataBase e SQL SELECT", ex);

        } finally {

            ConnectionFactory.closeConnectionResult(conexao, preSta, resSet);

        }

        LOG.info("Busca de pessoas cadastradas realizada com sucesso!");

        return users;

    }

    public static synchronized Login Read(int id) {

        conexao = ConnectionFactory.getConnection();
        preSta = null;
        resSet = null;

        Login user = new Login();
        StringBuilder select = new StringBuilder();

        try {

            select.append("SELECT ");
            select.append("matricula, ");
            select.append("senha ");
            select.append("FROM login ");
            select.append("WHERE pessoa_id = ");
            select.append(id);
            select.append(" ; ");

            preSta = conexao.prepareStatement(select.toString());
            resSet = preSta.executeQuery();

            if (resSet.next()) {

                user.setMatricula(resSet.getString("matricula"));
                user.setSenha(resSet.getString("senha"));

            }

        } catch (SQLException ex) {

            LOG.log(Level.SEVERE, "Erro de DataBase e SQL SELECT", ex);

        } finally {

            ConnectionFactory.closeConnectionResult(conexao, preSta, resSet);

        }

        LOG.info("Busca de pessoas cadastradas realizada com sucesso!");

        return user;

    }

    public static synchronized void Update(Login user) {

        conexao = ConnectionFactory.getConnection();
        preSta = null;

        StringBuilder update = new StringBuilder();

        try {

            update.append("UPDATE login SET ");
            update.append("senha = ? ");
            update.append("WHERE matricula = ? ");
            update.append("AND ");
            update.append("ativo = TRUE; ");

            preSta = conexao.prepareStatement(update.toString());

            preSta.setString(1, user.getSenha());
            preSta.setString(2, user.getMatricula());

            preSta.executeUpdate();

            LOG.info("Cadastro atualizado com sucesso!");

        } catch (SQLException ex) {

            LOG.log(Level.SEVERE, "Erro de DataBase e SQL UPDATE", ex);

        } finally {

            ConnectionFactory.closeConnectionStatement(conexao, preSta);

        }

    }

    public static synchronized void Delete(int user) {

        conexao = ConnectionFactory.getConnection();
        preSta = null;

        StringBuilder delete = new StringBuilder();

        try {

            delete.append("UPDATE login ");
            delete.append("SET ativo = FALSE ");
            delete.append("WHERE pessoa_id = ?; ");

            preSta = conexao.prepareStatement(delete.toString());

            preSta.setInt(1, user);

            preSta.executeUpdate();

            LOG.info("Cadastro deletado com sucesso!");

        } catch (SQLException ex) {

            LOG.log(Level.SEVERE, "Erro de DataBase e SQL DELETE", ex);

        } finally {

            ConnectionFactory.closeConnectionStatement(conexao, preSta);

        }

    }

}
