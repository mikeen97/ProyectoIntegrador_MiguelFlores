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
public class Rebeldes extends Pieza {

    public Rebeldes() {
    }

    @Override
    public String toString() {
        return "|R|";
    }

    @Override
    public int movimiento(Pieza[][] matriz, int posx, int posy, int moverx, int movery) {
        int retorno = 0, movimientos = 0, ladoAmover = 0, cont = 1;
        boolean prueba = false;
        Pieza e = new EspacioEnBlanco();
        if (posx == moverx || posy == movery) {
            if (posx == moverx) {//movimiento vertical
                ladoAmover = posy - movery;
                if (ladoAmover < 0) {//Abajo
                    movimientos = Math.abs(ladoAmover);
                    for (int i = 1; i <= movimientos; i++) {
                        if (matriz[posy + i][posx] instanceof Rebeldes) {
                            return 1;
                        }
                    }
                    return 2;
                }
                if (ladoAmover > 0) {//arriba
                    movimientos = Math.abs(ladoAmover);
                    for (int i = 1; i <= movimientos; i++) {
                        if (matriz[posy - i][posx] instanceof Rebeldes) {
                            return 1;
                        }
                    }
                    return 2;
                }
            }
            if (posy == movery) {//movimiento horizontal
                ladoAmover = posx - moverx;
                if (ladoAmover < 0) {//Abajo
                    movimientos = Math.abs(ladoAmover);
                    for (int i = 1; i <= movimientos; i++) {
                        if (matriz[posy][posx + i] instanceof Rebeldes) {
                            return 1;
                        }
                    }
                    return 2;
                }
                if (ladoAmover > 0) {//arriba
                    movimientos = Math.abs(ladoAmover);
                    for (int i = 1; i <= movimientos; i++) {
                        if (matriz[posy][posx - i] instanceof Rebeldes) {
                            return 1;
                        }
                    }
                    return 2;
                }
            }
        } else {
            retorno = 2;
        }
        return retorno;
    }

    @Override
    public void comida(Pieza[][] matriz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
