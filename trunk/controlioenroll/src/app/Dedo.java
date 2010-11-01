/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

/**
 *
 * @author Cristian Quintana
 */
public class Dedo {
    protected int idDedo;
    protected String dedo;

    public String getDedo() {
        return dedo;
    }

    public void setDedo(String dedo) {
        this.dedo = dedo;
    }


    public int getIdDedo() {
        return idDedo;
    }

    public void setIdDedo(int idDedo) {
        this.idDedo = idDedo;
    }

    @Override
    public String toString() {
        return this.getDedo();
    }

}
