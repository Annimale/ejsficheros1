
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ivamar
 */
public class ej3 {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);

        String nombreFichero = "";
        int lineas = 0;

        System.out.println("Introduzca el nombre que quiere tener como fichero");
        nombreFichero = tcl.nextLine() + ".txt";
        System.out.println("Ahora introduzca las lineas que quiera");
        lineas = tcl.nextInt();

        BufferedReader br1 = null;
        BufferedWriter bw = null;

        String t1 = "texto1.txt";

        try {
            br1 = new BufferedReader(new FileReader(t1));
            bw = new BufferedWriter(new FileWriter(nombreFichero, false));
            int contador = 0;

            String texto1 = br1.readLine();

            while (texto1 != null) {
                if (texto1.length() >= lineas) {
                    bw.write(texto1);
                    bw.newLine();
                    contador++;
                }
                texto1 = br1.readLine();
                
            }
            if (contador==0) {//Metemos un contador para que si el fichero que tenemos no tiene ninguna linea que sea superior a la introducida me crea un archivo con este texto
                    bw.write("Has excedido el tamaño");
                }

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (br1 != null) {
                    br1.close();
                }

                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }

    }
}
