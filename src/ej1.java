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
public class ej1 {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);

        String nombreFichero = "";
        char separador;

        System.out.println("Introduzca el nombre que quiere tener como fichero");
        nombreFichero = tcl.nextLine()+".txt";
        System.out.println("Ahora introduzca el caracter que quiere como separador");
        separador = tcl.next().charAt(0);
        
        BufferedReader br1=null;
        BufferedReader br2=null;
        BufferedWriter bw=null;
        String t1="texto1.txt";
        String t2="texto2.txt";
        
        try{
            br1= new BufferedReader (new FileReader(t1));
            br2= new BufferedReader (new FileReader(t2));
            bw= new BufferedWriter(new FileWriter(nombreFichero,true));
            
            String texto1 =br1.readLine();
            String texto2 =br2.readLine();
            
            while(texto1!=null || texto2!=null){
                bw.write(texto1 +separador+texto2);
                bw.newLine();
                
                texto1=br1.readLine();
                texto2=br2.readLine();
            }
        }catch (FileNotFoundException e){
            System.out.println("Fichero no encontrado");
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
            
            
        }finally{
            try{
                if (br1 !=null) {
                    br1.close();
                }
                if (br2 !=null) {
                    br2.close();
                }
                if (bw !=null) {
                    bw.close();
                }
            }catch (IOException e){
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
        
        
    }
}
