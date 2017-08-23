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
public class EspacioEnBlanco extends Pieza {

    public EspacioEnBlanco() {
    }

    @Override
    public String toString() {
        return "| |";
    }

    @Override
    public int movimiento(Pieza[][] matriz, int posx, int posy, int moverx, int movery) {
        return 1;
    }

    @Override
    public void comida(Pieza[][] matriz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
