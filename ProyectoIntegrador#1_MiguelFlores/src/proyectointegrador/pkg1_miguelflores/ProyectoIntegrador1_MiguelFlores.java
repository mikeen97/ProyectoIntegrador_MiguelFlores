/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegrador.pkg1_miguelflores;

import java.awt.Color;
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
    //clases
    static Rebeldes rebelde = new Rebeldes();
    static Rey rey = new Rey();
    static Duques duque = new Duques();
    static EspacioEnBlanco vacio = new EspacioEnBlanco();

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        String morir = "s";
        boolean continuar = true;
        Pieza tablero[][] = new Pieza[19][19];
        CrearTablero(tablero);
        tablero[9][2] = new Rey();

        System.out.println("");
        while (continuar) {
            for (int i = 0; i < 19; i++) {
                System.out.print("|" + i + "|\t");
            }
            System.out.println("");
            PrintMatrizRecursiva(tablero, 0, 0);
            System.out.println("Ingrese x");
            int posx = leer.nextInt();
            System.out.println("Ingrese y");
            int posy = leer.nextInt();
            System.out.println("Ingrese mover x");
            int moverx = leer.nextInt();
            System.out.println("Ingrese mover y");
            int movery = leer.nextInt();
            if (tablero[posy][posx] instanceof Rebeldes) {
                if (rebelde.movimiento(tablero, posx, posy, moverx, movery) == 1) {
                    System.out.println("No se puede realiza movimiento");
                } else {
                    tablero[posy][posx] = vacio;
                    tablero[movery][moverx] = rebelde;
                }

            }
            if (tablero[posy][posx] instanceof Duques) {
                if (duque.movimiento(tablero, posx, posy, moverx, movery) == 1) {
                    System.out.println("No se puede realiza movimiento");
                } else {
                    tablero[posy][posx] = vacio;
                    tablero[movery][moverx] = duque;
                }

            }
            if (tablero[posy][posx] instanceof Rey) {
                if (rey.movimiento(tablero, posx, posy, moverx, movery) == 1) {
                    System.out.println("No se puede realiza movimiento");
                } else {
                    tablero[posy][posx] = vacio;
                    tablero[movery][moverx] = rey;
                }

            }
            if (tablero[posy][posx] instanceof EspacioEnBlanco) {
                System.out.println("Selecciono espacio vacio");
            }
            duque.comida(tablero);
            rey.comida(tablero);
            rebelde.comida(tablero);
        }

    }

    public static void PrintMatrizRecursiva(Pieza x[][], int f, int c) {
        if (f == x.length - 1 && c == x.length - 1) {
            System.out.print(x[f][c] + "  |" + f + "|\t");
        } else {
            if (c == x[0].length - 1) {
                System.out.println(x[f][c] + "  |" + f + "|" + "\t");
                PrintMatrizRecursiva(x, f + 1, 0);
            } else {
                System.out.print(x[f][c] + "\t");
                PrintMatrizRecursiva(x, f, c + 1);
            }
        }
    }

    public static void CrearTablero(Pieza matriz[][]) {
        Pieza x[][] = new Pieza[19][19];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                matriz[i][j] = new EspacioEnBlanco();
            }
        }
        for (int i = 0; i < 2; i++) {
            matriz[0 + i][0] = new Castillo_x();
            matriz[0 + i][1] = new Castillo_x();
            matriz[1][17 + i] = new Castillo_x();
            matriz[0][17 + i] = new Castillo_x();
            matriz[17 + i][17] = new Castillo_x();
            matriz[17 + i][18] = new Castillo_x();
            matriz[18][0 + i] = new Castillo_x();
            matriz[17][0 + i] = new Castillo_x();
        }

        for (int i = 0; i < 5; i++) {
            matriz[3 + i][7 - i] = new Rebeldes();
            matriz[3 + i][11 + i] = new Rebeldes();
            matriz[11 + i][3 + i] = new Rebeldes();
            matriz[15 - i][11 + i] = new Rebeldes();

        }
        for (int i = 0; i < 2; i++) {
            matriz[10 - i * 2][4] = new Duques();
            matriz[9][3 + i * 12] = new Rebeldes();
            matriz[10 - i * 2][14] = new Duques();
            matriz[4][8 + i * 2] = new Duques();
            matriz[14][8 + i * 2] = new Rebeldes();
            matriz[3 + i * 12][9] = new Rebeldes();

        }

        for (int i = 0; i < 3; i += 2) {
            matriz[14 + i][0] = new Rebeldes();
            matriz[0][14 + i] = new Rebeldes();
            matriz[18][16 - i] = new Rebeldes();
            matriz[16 - i][18] = new Rebeldes();
            matriz[0][2 + i] = new Rebeldes();
            matriz[2 + i][0] = new Rebeldes();
            matriz[18][2 + i] = new Rebeldes();
            matriz[2 + i][18] = new Rebeldes();

        }
        int posx = 6;
        int posy = 9;
        for (int i = 0; i < 4; i++) {
            int posicion_x = 0;
            for (int j = 0; j < 4; j++) {
                matriz[posx + posicion_x][posy + j] = new Duques();
                posicion_x++;
            }
            posx++;
            posy--;
        }
        int cont = 0;
        matriz[16][4] = new Rebeldes();
        matriz[14][2] = new Rebeldes();
        matriz[2][4] = new Rebeldes();
        matriz[4][2] = new Rebeldes();
        matriz[4][16] = new Rebeldes();
        matriz[2][14] = new Rebeldes();
        matriz[14][16] = new Rebeldes();
        matriz[16][14] = new Rebeldes();
        matriz[9][9] = new Rey();
    }

}
