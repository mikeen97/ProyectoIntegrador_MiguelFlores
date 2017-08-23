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
public class Castillo_x extends Pieza{

    public Castillo_x() {
    }

    @Override
    public String toString() {
        return "|X|" ;
    }
    
    @Override
    public int movimiento(Pieza[][] matriz, int posx, int posy, int moverx, int movery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
