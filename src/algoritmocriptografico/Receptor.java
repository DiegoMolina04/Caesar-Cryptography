/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmocriptografico;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Receptor {

    static Receptor objReceptor = new Receptor(); //Objeto de la clase Receptor.
    static ArrayList arrayAbecedario = new ArrayList(); //Array donde se carga el abecedario.
    static ArrayList arrayEncriptado = new ArrayList(); //Array donde se carga el abecedario con el desplazamiento.
    static ArrayList arrayResultado = new ArrayList(); //Array donde se carga el mensaje desencriptado.

    public static void arrayAbecedario() { //Método que carga el abecedario.

        System.out.println("Abecedario sin encriptar\n");

        for (char c = 'a'; c <= 'z'; c++) {

            if (c == 'n') {

                arrayAbecedario.add(c);
                arrayAbecedario.add("ñ");

            } else {

                arrayAbecedario.add(c);

            }

        }

        for (int i = 0; i < arrayAbecedario.size(); i++) {
            System.out.print(arrayAbecedario.get(i));
        }
    }

    public static void arrayEncriptacion(int desplazamiento) { //Meétodo que carga el abecedario con el desplazamiento.

        System.out.println("");
        System.out.println("--------------------------------------------");
        System.out.println("Abecedario con desplazamiento\n");

        char letraDesplazamiento = (char) arrayAbecedario.get(desplazamiento);
        for (char c = letraDesplazamiento; c <= 'z'; c++) {

            if (c == 'n') {

                arrayEncriptado.add(c);
                arrayEncriptado.add("ñ");

            } else {

                arrayEncriptado.add(c);

            }
        }

        for (char c = 'a'; c < letraDesplazamiento; c++) {

            if (c == 'n') {

                arrayEncriptado.add(c);
                arrayEncriptado.add("ñ");

            } else {

                arrayEncriptado.add(c);

            }
        }

        for (int i = 0; i < arrayEncriptado.size(); i++) {
            System.out.print(arrayEncriptado.get(i));
        }
        System.out.println("");
        System.out.println("--------------------------------------------");
    }

    public static void desencriptar(int desplazamiento, ArrayList arrayLetras) { //Método que desencripta el mensaje enviado por el emisor.

        for (int i = 0; i < arrayLetras.size(); i++) {

            for (int j = 0; j < arrayEncriptado.size(); j++) {
                
                if (arrayLetras.get(i).equals(arrayEncriptado.get(j))) {//Se valida si el array con el mensaje en la posición i, es igual al arrayEncriptado en la posición j.
                    
                    char letra = (char) arrayAbecedario.get(j); //Se toma la posición en el arrayAbecedario y se convierte a caracter.
                    
                    arrayResultado.add(letra); //Se añade al arrayResultado.
                    
                }

            }

        }
     
        System.out.println("Mensaje desencriptado\n");
        for (int i = 0; i < arrayResultado.size(); i++) { //For que imprime el mensaje desencriptado.
            
            System.out.print(arrayResultado.get(i));
            
        }
        System.out.println("");
        System.out.println("--------------------------------------------");

    }

    public static void recibirMensaje(int desplazamiento, ArrayList arrayLetras) { //Método que recibe el mensaje encriptado y el desplazamiento.
        
        System.out.println("--------------------------------------------");
        System.err.println("Desde el receptor");
        System.out.println("--------------------------------------------");
        
        arrayAbecedario(); //Se carga el arrayAbecedario.
        arrayEncriptacion(desplazamiento); //Se carga el arrayEncriptación.
        desencriptar(desplazamiento, arrayLetras); //Se desencripta el mensaje.

    }

}
