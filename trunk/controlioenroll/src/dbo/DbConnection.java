/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbo;
import java.sql.Connection;

/**
 *
 * @author null
 */
public abstract class DbConnection {

    private String host;
    private String user;
    private String dbName;
    private String dbPasswd;

    
    abstract public Connection DbConnect();
    abstract public void DbDisconnect();
    

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the dbName
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * @param dbName the dbName to set
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /**
     * @return the dbPasswd
     */
    public String getDbPasswd() {
        return dbPasswd;
    }

    /**
     * @param dbPasswd the dbPasswd to set
     */
    public void setDbPasswd(String dbPasswd) {
        this.dbPasswd = dbPasswd;
    }
}
