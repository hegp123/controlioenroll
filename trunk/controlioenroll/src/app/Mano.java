/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

/**
 *
 * @author Cristian Quintana
 */
public class Mano {
    protected int idMano;
    protected String mano;

    public String getMano() {
        return mano;
    }

    public void setMano(String mano) {
        this.mano = mano;
    }


    public int getIdMano() {
        return idMano;
    }

    public void setIdMano(int idMano) {
        this.idMano = idMano;
    }

    @Override
    public String toString() {
        return this.getMano();
    }

}
