/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

/**
 *
 * @author Administrator
 */
public class FingerPrint {
    

    public static boolean inserFingerPrint(int idPersona, int idMano, int idDedo){

        //comprobar si existe, si ya existe, hacer un update

        try{
            Connection con = (Connection) dbo.DbMySQLConnection.DbConnect();
            //tenemos en fptWriterFile = "fpts/writer/currentWriteFpt.fpt" el ultimo escrito
            PreparedStatement ps = con.prepareStatement("insert into fotos(foto) values (?)");

            con.setAutoCommit(false);
            File file = new File(Config.fptWriterFile);
            FileInputStream fis = new FileInputStream(file);
            ps.setBinaryStream(1, fis, (int) file.length());
            ps.executeUpdate();
            con.commit();
            ps.close();

            return true;
        }catch(Exception e){
            Message.showErrorMessage(null, e.getMessage());
            e.printStackTrace();
            return false;
        }
        
    }

}
