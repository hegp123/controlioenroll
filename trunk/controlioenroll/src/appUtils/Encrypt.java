package appUtils;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */

import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.*;
import java.util.*;

public class Encrypt
{
    public static String encryptMD5(String code){
            try{
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    byte[] input = code.getBytes(); //"UTF8");
                    input=md.digest(input);
                    code = toHexadecimal(input); //new String(input,"UTF8");

                    return code;
            }catch(Exception e){

                    return code;
            }

    }
    private static String toHexadecimal(byte[] datos)
    {
        String resultado="";
        ByteArrayInputStream input = new ByteArrayInputStream(datos);
        String cadAux;
        boolean ult0=false;
        int leido = input.read();
        while(leido != -1)
        {
                cadAux = Integer.toHexString(leido);
                if(cadAux.length() < 2){ //Hay que aÒadir un 0
                        resultado += "0";
                        if(cadAux.length() == 0)
                            ult0=true;
                }else{ ult0=false;}
                resultado += cadAux;
                leido = input.read();
        }
        if(ult0)//quitamos el 0 si es un caracter aislado
                            resultado=
                                    resultado.substring(0, resultado.length()-2)+resultado.charAt(resultado.length()-1);
        return resultado;
    }

    public static void main(String args []){
        String password = encryptMD5("r00t");
        System.out.println("Codigo hash MD5 para r00t =" + password);
        System.exit(0);

    }

    public static void main2(String [] args)
    {

	    //declarar funciones resumen
		try{
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");  // Inicializa MD5
		MessageDigest messageDigest2 = MessageDigest.getInstance("SHA"); // Inicializa SHA-1

		//leer fichero byte a byte

			try{
				InputStream archivo = new FileInputStream( args[0] );
				byte[] buffer = new byte[1];
				int fin_archivo = -1;
				int caracter;

				caracter = archivo.read(buffer);

				while( caracter != fin_archivo ) {

					messageDigest.update(buffer);  // Pasa texto claro a la función resumen
					messageDigest2.update(buffer);
					caracter = archivo.read(buffer);
				}

				archivo.close();
				byte[] resumen = messageDigest.digest(); // Genera el resumen MD5
				byte[] resumen2 = messageDigest2.digest(); // Genera el resumen SHA-1

				//Pasar los resumenes a hexadecimal

				String s = "";
				for (int i = 0; i < resumen.length; i++)
				{
					s += Integer.toHexString((resumen[i] >> 4) & 0xf);
					s += Integer.toHexString(resumen[i] & 0xf);
				}
				System.out.println("Resumen MD5: " + s);


				String m = "";
				for (int i = 0; i < resumen2.length; i++)
				{
					m += Integer.toHexString((resumen2[i] >> 4) & 0xf);
					m += Integer.toHexString(resumen2[i] & 0xf);
				}
				System.out.println("Resumen SHA-1: " + m);


			}
			//lectura de los datos del fichero
			catch(java.io.FileNotFoundException fnfe) {}
			catch(java.io.IOException ioe) {}

		}
		//declarar funciones resumen
		catch(java.security.NoSuchAlgorithmException nsae) {}

	}

}