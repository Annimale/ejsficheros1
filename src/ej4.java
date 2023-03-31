
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
public class ej4 {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);

        String dni = "";
        dni = "dni.txt";
        String nif = "";
        nif = "nif.txt";

        

        BufferedWriter bw1 = null;
        BufferedWriter bw2 = null;

        try {

            bw1 = new BufferedWriter(new FileWriter(dni, false));
            bw2 = new BufferedWriter(new FileWriter(nif, false));

            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

            int num1;
            int num2;
            String num_texto = null;
            int letra_nif;

            System.out.println("Introduzca el primer numero");
            num1 = tcl.nextInt();
            System.out.println("Introduzca el numero final");
            num2 = tcl.nextInt();

            for (int i = num1; i <= num2; i++) {
                num_texto = String.valueOf(i);
                while (num_texto.length() < 8) {
                    num_texto = "0" + num_texto;

                }
                bw1.write(num_texto);
                bw1.newLine();
                letra_nif=Integer.parseInt(num_texto)%23;
                bw2.write(num_texto+letras.charAt(letra_nif));
                bw2.newLine();
            }

            }catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
            System.out.println(e.getMessage());
        }catch (IOException e) {
            System.out.println(e.getMessage());

        }finally {
            try {
                if (bw1 != null) {
                    bw1.close();
                }

                if (bw2 != null) {
                    bw2.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }

        }
    }


