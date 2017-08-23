/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegrador.pkg1_miguelflores;

import java.awt.Color;

/**
 *
 * @author Miguel Flores
 */
public abstract class Pieza {

    public abstract int movimiento(Pieza[][] matriz, int posx, int posy, int moverx, int movery);

    public abstract void comida(Pieza[][] matriz);

}
