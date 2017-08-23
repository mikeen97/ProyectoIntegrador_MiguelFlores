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
public class Duques extends Pieza {

    public Duques() {
    }

    @Override
    public String toString() {
        return "|D|";
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
                    while (cont <= movimientos && prueba == false) {
                        System.out.println("pieza " + matriz[posy][posx]);
                        if (matriz[posy + cont][posx].equals(e)) {
                            System.out.println("111");
                            System.out.println(matriz[posy - cont][posx].equals(e));
                            prueba = false;
                            retorno = 1;//libre
                        } else {
                            System.out.println("2222");
                            prueba = true;
                            retorno = 2;//encontro pieza enmedio
                        }
                        cont++;
                    }
                }
                if (ladoAmover > 0) {//arriba
                    movimientos = Math.abs(ladoAmover);
                    System.out.println("movimientos: " + movimientos);
                    while (cont <= movimientos && prueba == false) {
                        System.out.println("pieza " + matriz[posy][posx]);
                        if (matriz[posy - cont][posx].equals(e)) {
                            System.out.println("111");
                            System.out.println(matriz[posy - cont][posx].equals(e));
                            prueba = false;
                            retorno = 1;//libre
                            System.out.println("retorno en while: " + retorno);
                            System.out.println("prueba en while: " + prueba);
                        } else {
                            System.out.println("2222");
                            prueba = true;
                            retorno = 2;//encontro pieza enmedio
                        }
                        cont++;
                    }
                }
            }
            if (posy == movery) {
            }
        } else {
            retorno = 2;
        }
        return retorno;
    }
}
