/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

/**
 *
 * @author Administrator
 */
public class Config {


    //varios de la app
    public static final String fptReaderFile = "fpts/reader/currentReadFpt.fpt";
    public static final String fptWriterFile = "fpts/writer/currentWriteFpt.fpt";
    
    //configuracione la bd
    public static final String dbHost = "192.168.3.53";
    public static final String dbUser = "cristian";
    public static final String dbName = "control_io";
    public static final String dbPasswd = "cristian.123";
    public static final String connectionUrl = "jdbc:myqsl://" + dbHost + "/" + dbName;   //no se por que no funciona si se le pasa directamente al getConnection()

}
