/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmocriptografico;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Emisor {

    static ArrayList arrayAbecedario = new ArrayList(); // Array donde se carga el abecedario.
    static ArrayList arrayLetras = new ArrayList(); // Array donde se cargan las letras encriptadas.
    static ArrayList arrayEncriptado = new ArrayList(); //Array donde se carga el abecedario con el desplazamiento.
    static String mensaje;
    static int desplazamiento;
    
    public static void arrayAbecedario() { //Método que carga las letras del abecedario en un array.
        System.out.println("--------------------------------------------");
        System.out.println("Abecedario sin encriptar\n");
        
        for (char c = 'a'; c <= 'z'; c++) { //For que es usado para recorrer las letras de la a hasta la z.

            if (c == 'n') {

                arrayAbecedario.add(c);
                arrayAbecedario.add("ñ");

            } else {

                arrayAbecedario.add(c);

            }

        }

        for (int i = 0; i < arrayAbecedario.size(); i++) { //For usado para imprimir el abecedario.
            System.out.print(arrayAbecedario.get(i));
        }
    }

    public static void arrayEncriptacion(int desplazamiento) { //Método que carga el array con el desplazamiento ingresado.
        System.out.println("");
        System.out.println("--------------------------------------------");
        System.out.println("Abecedario con desplazamiento\n");
        
        char letraDesplazamiento = (char) arrayAbecedario.get(desplazamiento); //Se toma la posición del desplazamiento sobre el arrayAbecedario y se convierte en un caracter.
        for (char c = letraDesplazamiento; c <= 'z'; c++) { //For que recorre desde la letra del desplazamiento hasta la z.

            if (c == 'n') { //Valida si c que es el interador es igual a n para poder agregar la letra ñ, ya que esta no es reconocida.

                arrayEncriptado.add(c);
                arrayEncriptado.add("ñ");

            } else {

                arrayEncriptado.add(c);

            }
        }

        for (char c = 'a'; c < letraDesplazamiento; c++) { //For que recorre desde la letra a hasta la letra del desplazamiento.

            if (c == 'n') {

                arrayEncriptado.add(c);
                arrayEncriptado.add("ñ");

            } else {

                arrayEncriptado.add(c);

            }
        }

        for (int i = 0; i < arrayEncriptado.size(); i++) { //For que imprime el array con el desplazamiento.
            System.out.print(arrayEncriptado.get(i));
        }
        
    }

    public static void arrayResultado(int desplazamiento, String mensaje) { //Método que guarda las letras encriptadas del mensaje.
        System.out.println("");
        System.out.println("--------------------------------------------");
        System.out.println("Mensaje encriptado\n");
        
        String aux = mensaje.toLowerCase();// Se toma el mensaje y se pasa a caracteres de minusculas para evitar errores.
        char vector[] = aux.toCharArray(); // Se pasa el mensaje a un vector de caracteres.
        
        for (int i = 0; i < vector.length; i++) {

            for (int j = 0; j < arrayAbecedario.size(); j++) {

                if (arrayAbecedario.get(j).equals(vector[i])) { //Se compara si en el arrayAbecedario en la posicion J, es igual a el caracter en el vector en la posición i.
                    
                    /*  
                    Para saber que letra tendra como encriptación, 
                    se realiza la ecuación C = M + b mod n, donde
                    C = Letra encriptada.
                    M = Posición de la letra a encriptar.
                    b = Desplazamiento deseado por el usuario.
                    n = El tamaño del alfabeto.
                    */
                    int operacion = (j + desplazamiento) % 27; //Ecuación utilizada.
                    if (arrayAbecedario.get(operacion).equals("ñ")) {//Se valida si la letra es ñ, de serlo, se inserta.
                        arrayLetras.add("ñ");
                    } else {

                        char letraEncriptada = (char) arrayAbecedario.get(operacion);
                        arrayLetras.add(letraEncriptada);
                    }
                  
                }

            }

        }

        for (int i = 0; i < arrayLetras.size(); i++) { //For que imprime el mensaje encriptado.
            System.out.print(arrayLetras.get(i));
        }
       
        System.out.println("");
        System.out.println("--------------------------------------------");

       
    }

    public static void main(String[] args) {

        boolean flag = true;
        Scanner scTexto = new Scanner(System.in);
        Scanner scNumero = new Scanner(System.in);
        System.out.println("--------------------------------------------");
        System.err.println("Desde el emisor");
        System.out.println("--------------------------------------------");
        while (flag) { //While usado para validar que se ingrese un valor correcto.

            System.out.println("Ingrese el mensaje a encriptar");
            mensaje = scTexto.nextLine();
            System.out.println("Ingrese el valor de desplazamiento");
            desplazamiento = scNumero.nextInt();

            if (desplazamiento == 0) {
                System.out.println("Error ! Ingrese un valor mayor a cero");
            } else {

                arrayAbecedario();
                arrayEncriptacion(desplazamiento);
                arrayResultado(desplazamiento, mensaje);
                flag = false;
            }

        }
        
        System.out.println("¿Desea enviar el mensaje al receptor? Si/No");
        String decision = scTexto.nextLine();
        
        decision.toLowerCase();
        if(decision.equals("si")){
            Receptor objReceptor = new Receptor(); //Se crea el objeto de la clase Receptor.
            objReceptor.recibirMensaje(desplazamiento, arrayLetras); //Se envia el mensaje encriptado y el desplazamiento.
        }else{
            System.out.println("Mensaje cancelado.");
        }
        
    }

}
