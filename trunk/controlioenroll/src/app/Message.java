/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author null
 */
public class Message {

    public Message(){
             
    }

    public static void showErrorMessage(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void showOkMessage(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message, "Atencion", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int showConfirmDialog(Component parent, String message, String title){
        return JOptionPane.showConfirmDialog(parent,"<html><center><font size = 3 color = black>" + message , title,JOptionPane.YES_NO_OPTION);
    }
}
