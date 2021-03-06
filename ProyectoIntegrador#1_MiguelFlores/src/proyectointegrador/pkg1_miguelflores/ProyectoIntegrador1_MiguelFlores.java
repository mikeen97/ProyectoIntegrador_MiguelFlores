/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegrador.pkg1_miguelflores;

import java.awt.Color;
import java.util.ArrayList;
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
    static ArrayList<jugador> ListJugadores = new ArrayList();

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String morir = "s";
        Pieza tablero[][] = new Pieza[19][19];

        String opcion = "";
        while (!opcion.equalsIgnoreCase("e")) {
            opcion = JOptionPane.showInputDialog("Menu\n"
                    + "a- Agregar Usuario \n"
                    + "b- Eliminar Usuario\n"
                    + "c- Listar Usuario\n"
                    + "d- Jugar\n"
                    + "e- Salir \n");
            if (opcion.equals("a")) {
                String nombre = "";
                nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador");
                ListJugadores.add(new jugador(nombre, 0, 0));
            }
            if (opcion.equals("b")) {
                int p = Integer.parseInt(
                        JOptionPane.showInputDialog("Posicion del Jugador a Eliminar"));
                ListJugadores.remove(p);
            }
            if (opcion.equals("c")) {
                String p1 = "";
                for (jugador t1 : ListJugadores) {
                    if (t1 instanceof jugador) {
                        p1 += ListJugadores.indexOf(t1) + " " + ((jugador) t1) + "\n";
                    }
                }
                JOptionPane.showMessageDialog(null, p1 + "\t");
            }
            if (opcion.equals("d")) {
                String p1 = "";
                for (jugador t1 : ListJugadores) {
                    if (t1 instanceof jugador) {
                        p1 += ListJugadores.indexOf(t1) + " " + ((jugador) t1) + "\n";
                    }
                }
                JOptionPane.showMessageDialog(null, p1 + "\t");
                CrearTablero(tablero);
                System.out.println("");
                int turno = 1;
                int player1 = Integer.parseInt(JOptionPane.showInputDialog("ingreso posicion del jugador de Rebeldes"));
                int player2 = Integer.parseInt(JOptionPane.showInputDialog("ingreso posicion del jugador de Duques"));
                int piezasRebeldes = cantidadRebeldes(tablero);
                int piezasDuques = cantidadDuques(tablero);
                boolean continuar = true;
                while (continuar) {
                    System.out.println("Cantidad de piezas \n"
                            + "Rebeldes: " + piezasRebeldes + "\n"
                            + "Duques: " + piezasDuques + "\n");
                    if (turno == 1) {
                        boolean RepTurno = true;
                        while (RepTurno) {
                            System.out.println("Turno de " + ListJugadores.get(player1).getNombre());
                            for (int i = 0; i < 19; i++) {
                                System.out.print("|" + i + "|\t");
                            }
                            System.out.println("");
                            PrintMatrizRecursiva(tablero, 0, 0);
                            System.out.println("");
                            System.out.print("Ingrese x:");
                            int posx = leer.nextInt();
                            System.out.print("Ingrese y:");
                            int posy = leer.nextInt();
                            System.out.print("Ingrese mover x:");
                            int moverx = leer.nextInt();
                            System.out.print("Ingrese mover y:");
                            int movery = leer.nextInt();
                            if (tablero[posy][posx] instanceof Rebeldes) {
                                if (rebelde.movimiento(tablero, posx, posy, moverx, movery) == 1) {
                                    System.out.println("No se puede realiza movimiento");
                                } else {
                                    tablero[posy][posx] = new EspacioEnBlanco();
                                    tablero[movery][moverx] = new Rebeldes();
                                    RepTurno = false;
                                    turno = 2;
                                }
                            } else if (tablero[posy][posx] instanceof Duques) {
                                System.out.println("Selecciono una pieza del contrario intente de nuevo");
                            } else if (tablero[posy][posx] instanceof EspacioEnBlanco) {
                                System.out.println("Selecciono espacio vacio, intente de nuevo");

                            }
                            duque.comida(tablero);
                            rey.comida(tablero);
                            rebelde.comida(tablero);
                        }

                    } else {
                        boolean RepTurno = true;
                        while (RepTurno) {
                            System.out.println("Turno de " + ListJugadores.get(player2).getNombre());
                            for (int i = 0; i < 19; i++) {
                                System.out.print("|" + i + "|\t");
                            }
                            System.out.println("");
                            PrintMatrizRecursiva(tablero, 0, 0);
                            System.out.println("");
                            System.out.print("Ingrese x:");
                            int posx = leer.nextInt();
                            System.out.print("Ingrese y:");
                            int posy = leer.nextInt();
                            System.out.print("Ingrese mover x:");
                            int moverx = leer.nextInt();
                            System.out.print("Ingrese mover y:");
                            int movery = leer.nextInt();
                            if (tablero[posy][posx] instanceof Duques) {
                                if (duque.movimiento(tablero, posx, posy, moverx, movery) == 1) {
                                    System.out.println("No se puede realiza movimiento");
                                } else {
                                    tablero[posy][posx] = new EspacioEnBlanco();
                                    tablero[movery][moverx] = new Duques();
                                    RepTurno = false;
                                    turno = 1;
                                }
                            } else if (tablero[posy][posx] instanceof Rey) {
                                if (rey.movimiento(tablero, posx, posy, moverx, movery) == 1) {
                                    System.out.println("No se puede realiza movimiento");
                                } else {
                                    tablero[posy][posx] = new EspacioEnBlanco();
                                    tablero[movery][moverx] = new Rey();
                                    RepTurno = false;
                                    turno = 1;
                                }
                            } else if (tablero[posy][posx] instanceof EspacioEnBlanco) {
                                System.out.println("Selecciono espacio vacio, intente de nuevo");
                            } else if (tablero[posy][posx] instanceof Rebeldes) {
                                System.out.println("Selecciono espacio vacio, intente de nuevo");
                            }
                            duque.comida(tablero);
                            rey.comida(tablero);
                            rebelde.comida(tablero);

                        }
                    }
                    if (ganarRebeldes(tablero) == 0) {
                        System.out.println("Gano " + ListJugadores.get(player1).getNombre());
                        continuar = false;
                        int puntos = ListJugadores.get(player1).getPuntos();
                        ListJugadores.get(player1).setPuntos(puntos + 100);
                    }
                    if (ganarDuques(tablero) == 0) {
                        System.out.println("Gano " + ListJugadores.get(player2).getNombre());
                        continuar = false;
                        int puntos = ListJugadores.get(player2).getPuntos();
                        ListJugadores.get(player2).setPuntos(puntos + 100);
                    }
                }
            }
        }
    }

    public static int ganarDuques(Pieza x[][]) {
        int cont = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (x[i][j] instanceof Rebeldes) {
                    cont = 1;//no gana
                }
            }
        }
        return cont;
    }

    public static int ganarRebeldes(Pieza x[][]) {
        int cont = 0;//gana
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (x[i][j] instanceof Rey) {
                    cont = 1;//no gana
                }
            }
        }
        return cont;
    }

    public static int cantidadRebeldes(Pieza x[][]) {
        int cont = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (x[i][j] instanceof Rebeldes) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static int cantidadDuques(Pieza x[][]) {
        int cont = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (x[i][j] instanceof Duques) {
                    cont++;
                }
                if (x[i][j] instanceof Rey) {
                    cont++;
                }
            }
        }
        return cont;
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
        matriz[14][8] = new Duques();
        matriz[14][10] = new Duques();
    }

}
