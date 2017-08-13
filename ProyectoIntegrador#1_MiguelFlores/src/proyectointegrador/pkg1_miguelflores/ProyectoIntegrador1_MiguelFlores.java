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
        String estado = "";
        String opcion = "";
        while (!opcion.equalsIgnoreCase("f")) {
            opcion = JOptionPane.showInputDialog("Menu\n"
                    + "a- Agregar Usuario \n"
                    + "b- Eliminar Usuario\n"
                    + "c- Listar Usuario\n"
                    + "d- Modificar Usuario\n"
                    + "e- Entrar a cuenta personal\n"
                    + "f- Salir \n");
            if (opcion.equals("a")) {
                
            }
        }
    }
}
