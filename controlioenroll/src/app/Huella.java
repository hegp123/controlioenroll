/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import java.util.Date;

/**
 *
 * @author null
 */
public class Huella {

    /*
    id
    persona
    mano
    dedo
    estado
    created
    imagen_huella
    */

    private int id;
    private int persona;
    private int mano;
    private int dedo;
    private boolean estado;
    private Date created;

    public Huella(){
        //...
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the persona
     */
    public int getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(int persona) {
        this.persona = persona;
    }

    /**
     * @return the mano
     */
    public int getMano() {
        return mano;
    }

    /**
     * @param mano the mano to set
     */
    public void setMano(int mano) {
        this.mano = mano;
    }

    /**
     * @return the dedo
     */
    public int getDedo() {
        return dedo;
    }

    /**
     * @param dedo the dedo to set
     */
    public void setDedo(int dedo) {
        this.dedo = dedo;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    

}
