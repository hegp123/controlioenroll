/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;

/**
 *
 * @author Administrator
 */
public class FingerPrint {

     public static FileOutputStream stream;
     public static File fpts;
    

     public static boolean saveFingerPrint(int idPersona, int idMano, int idDedo) throws Exception{
        try{
            fpts = new File(Config.fptWriterFile);
            stream = new FileOutputStream(fpts);
            stream.write(Principal.getTemplate().serialize());
            stream.close();

            try {
                Connection con = (Connection) dbo.DbMySQLConnection.DbConnect();
                PreparedStatement ps = null;
                /*id:persona:mano:dedo:estado:creaed:imagen_huella*/
                if (con != null) {
                    try {
                        con.setAutoCommit(false);
                        String query = null;            //la que almacenara el insert o el update...
                        String checkFinger = "select id, count(*) as cantidad from huella where persona = ? and mano = ? and dedo = ?";
                        ps = (PreparedStatement) con.prepareStatement (checkFinger);
                        ps.setInt(1, idPersona);
                        ps.setInt(2, idMano);
                        ps.setInt(3, idDedo);
                        ResultSet rs = ps.executeQuery();
                        int cantidad = -1;  //inicializamos a valores no permitidos
                        int idHuella = -1;
                        while(rs.next()){
                            cantidad = rs.getInt("cantidad");
                            idHuella = rs.getInt("id");
                        }
                        File file = new File(Config.fptWriterFile);
                        FileInputStream fis = new FileInputStream(file);

                        if(cantidad > 0){
                            //hacer un update
                            Message.showOkMessage(null, "Update " + idHuella);
                            query = "update huella set imagen_huella = ?, changed = now(), estado = 0 where id = ?";
                            ps = (PreparedStatement) con.prepareStatement(query);
                            ps.setBinaryStream(1, fis, (int) file.length());    //el archivo
                            ps.setInt(2, idHuella);                            
                        }else if(cantidad == 0){
                            //hacer un insert
                            query = "insert into huella (persona, mano, dedo, estado, created, imagen_huella) values (?,?,?,?, now(), ?) ";
                            ps = (PreparedStatement) con.prepareStatement(query);
                            ps.setInt(1, idPersona);
                            ps.setInt(2, idMano);
                            ps.setInt(3, idDedo);
                            ps.setBoolean(4, true);
                            ps.setBinaryStream(5, fis, (int) file.length());    //el archivo
                        }                                                                       
                        //exec el query
                        ps.executeUpdate();
                        //commit
                        con.commit();
                    } catch (SQLException es) {
                        ps.close();
                        es.printStackTrace();
                        Message.showErrorMessage(null, es.getMessage());
                        return false;
                    } catch (FileNotFoundException e){
                        Message.showErrorMessage(null, e.getMessage());
                        e.printStackTrace();
                        return false;
                    }
                }
            } catch (Exception se) {
                Message.showErrorMessage(null, se.getMessage());
                se.printStackTrace();
                return false;
            }
            Message.showOkMessage(null, "Huella registrada correctamente.");
            return true;
        }catch(Exception e){
            Message.showErrorMessage(null, e.getMessage());   //un dialogo con informacion
            e.printStackTrace();//para la consola
            return false;
        }
    }   

}
