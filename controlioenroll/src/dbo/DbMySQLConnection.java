/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbo;

/**
 *
 * @author null
 */

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbMySQLConnection {

    public static Connection con = null;

    public static final String dbHost = "192.168.3.53";
    public static final String dbUser = "cristian";
    public static final String dbName = "control_io";
    public static final String dbPasswd = "cristian.123";
    public static final String connectionUrl = "jdbc:myqsl://" + dbHost + "/" + dbName;   //no se por que no funciona si se le pasa directamente al getConnection()
    
    public static Connection DbConnect() {
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+dbHost+"/"+dbName, DbMySQLConnection.dbUser , DbMySQLConnection.dbPasswd);
        }
        catch (Exception e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        }
        return con;        
    }
    
    public static void DbDisconnect() {
        if (DbMySQLConnection.con != null) {
            try {
                DbMySQLConnection.con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static ResultSet simpleQuery(String query) throws SQLException{
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }   
}
