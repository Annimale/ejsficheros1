/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ivamar
 */
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
public class ej2 {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);

        String nombreFichero = "";
        char separador;

        System.out.println("Introduzca el nombre que quiere tener como fichero");
        nombreFichero = tcl.nextLine() + ".txt";
        System.out.println("Ahora introduzca el caracter que quiere como separador");
        separador = tcl.next().charAt(0);

        BufferedReader br1 = null;
        BufferedReader br2 = null;
        BufferedWriter bw = null;
        
        String t1 = "texto1.txt";
        String t2 = "texto2.txt";

        try {
            br1 = new BufferedReader(new FileReader(t1));
            br2 = new BufferedReader(new FileReader(t2));
            bw = new BufferedWriter(new FileWriter(nombreFichero, false));

            String texto1 = br1.readLine();
            String texto2 = br2.readLine();

            int lineas1 = 1;///Pongo 1 porque sino en el for posterior tendría que poner <=lineas1 mientras que si pongo lineas=1 en el bucle <lineas1
            int lineas2 = 1;

            while (br1.readLine()!= null) {//br1.readLine()! aqui estaba el error, esto no es lo mismo que texto1
                lineas1++;
            }
            while (br2.readLine()!= null) {
                lineas2++;
            }
            
            br1 = new BufferedReader(new FileReader(t1));
            br2 = new BufferedReader(new FileReader(t2));
            for (int i = 0; i < lineas1; i++) {
                texto1 = br1.readLine();
                br2 = new BufferedReader(new FileReader(t2));
                for (int j = 0; j < lineas2; j++) {
                    texto2 = br2.readLine();
                    bw.write(texto1 + separador + texto2);
                    bw.newLine();

                }
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
                if (br2 != null) {
                    br2.close();
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
