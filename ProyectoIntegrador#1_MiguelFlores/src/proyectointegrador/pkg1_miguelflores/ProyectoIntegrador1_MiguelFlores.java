/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegrador.pkg1_miguelflores;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Flores
 */
public class ProyectoIntegrador1_MiguelFlores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int comenzar = 0;
        int opcion = 0;
        String morir = "s";
        boolean continuar = true;
        while (morir.equalsIgnoreCase("s")) {
            
        }
    }

    public static void PrintMatrizRecursiva(String x[][], int f, int c) {

        if (f == x.length - 1 && c == x.length - 1) {
            System.out.print(x[f][c] + "");
        } else {
            if (c == x[0].length - 1) {
                System.out.println(x[f][c]);
                PrintMatrizRecursiva(x, f + 1, 0);
            } else {
                System.out.print(x[f][c] + " ");
                PrintMatrizRecursiva(x, f, c + 1);
            }
        }
    }
}
