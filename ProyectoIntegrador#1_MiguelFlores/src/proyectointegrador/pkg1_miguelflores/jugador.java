/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegrador.pkg1_miguelflores;

/**
 *
 * @author Miguel Flores
 */
public class jugador {

    private String nombre;
    private int piezas;
    private int puntos;

    public jugador() {
    }

    public jugador(String nombre, int piezas, int puntos) {
        this.nombre = nombre;
        this.piezas = piezas;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "  Piezas: " + piezas + "Puntos: " + puntos;
    }

}
