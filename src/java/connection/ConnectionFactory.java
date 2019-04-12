package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String SERVER = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String BANCO = "pwsa";
    private static final String TIMEZONE = "useTimezone=true&serverTimezone=UTC";
    private static final String SSL = "verifyServerCertificate=false&useSSL=true";
    private static final String USER = "root";
    private static final String PASSWORD = "aa010498";
    
    private static final String URL = "jdbc:mysql://" + SERVER + ":" + PORT + "/" + BANCO + "?" + TIMEZONE + "&" + SSL;
    
    private static Connection connection;

    public static synchronized Connection getConnection() {
        
        try {
    
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            return connection;
        
        } catch (ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            
            return connection;
        }
    }

    public static synchronized void closeConnectionStatement(Connection con, PreparedStatement stmt) {
        
        try {
            
            if (con != null && stmt != null) {
            
                con.close();
                stmt.close();
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }

    public static synchronized void closeConnectionResult(Connection con, PreparedStatement stmt, ResultSet rs) {
        
        try {
        
            if (con != null && stmt != null && rs != null) {
            
                con.close();
                stmt.close();
                rs.close();
            
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }

    public static String getURL() {
    
        return URL;
    
    }
    
}