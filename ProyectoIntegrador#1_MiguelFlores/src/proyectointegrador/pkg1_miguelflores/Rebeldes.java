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
        if (matriz[movery][moverx] instanceof Castillo_x) {
            return 1;
        }
        if (matriz[movery][moverx] == matriz[9][9]) {
            return 1;
        }
        if (posx == moverx || posy == movery) {
            if (posx == moverx) {//movimiento vertical
                ladoAmover = posy - movery;
                if (ladoAmover < 0) {//Abajo
                    movimientos = Math.abs(ladoAmover);
                    for (int i = 1; i <= movimientos; i++) {
                        if (matriz[posy + i][posx] instanceof Rebeldes || matriz[posy + i][posx] instanceof Duques || matriz[posy + i][posx] instanceof Rey) {
                            return 1;
                        }
                    }
                    return 2;
                }
                if (ladoAmover > 0) {//arriba
                    movimientos = Math.abs(ladoAmover);
                    for (int i = 1; i <= movimientos; i++) {
                        if (matriz[posy - i][posx] instanceof Rebeldes || matriz[posy - i][posx] instanceof Duques || matriz[posy - i][posx] instanceof Rey) {
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
                        if (matriz[posy][posx + i] instanceof Rebeldes || matriz[posy][posx + i] instanceof Duques || matriz[posy][posx + i] instanceof Rey) {
                            return 1;
                        }
                    }
                    return 2;
                }
                if (ladoAmover > 0) {//arriba
                    movimientos = Math.abs(ladoAmover);
                    for (int i = 1; i <= movimientos; i++) {
                        if (matriz[posy][posx - i] instanceof Rebeldes || matriz[posy][posx - i] instanceof Duques || matriz[posy][posx - i] instanceof Rey) {
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
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (matriz[i][j] instanceof Duques) {
                    if (i != 0 && i != 18 && j != 0 && j != 18) {//verifico de arriba a abajo
                        if (matriz[i + 1][j] instanceof Rebeldes && matriz[i - 1][j] instanceof Rebeldes
                                || matriz[i][j + 1] instanceof Rebeldes && matriz[i][j - 1] instanceof Rebeldes) {
                            matriz[i][j] = new EspacioEnBlanco();
                            System.out.println("Rebeldes comio en: i=" + i + " j=" + j);
                        }
                    }
                    if (j > 0 && j < 18 && i == 0) {//lado arriba
                        if (matriz[i][j + 1] instanceof Rebeldes && matriz[i][j - 1] instanceof Rebeldes) {
                            matriz[i][j] = new EspacioEnBlanco();
                            System.out.println("Rebeldes comio en: i=" + i + " j=" + j);
                        }
                    }
                    if (j > 0 && j < 18 && i == 18) {//lado abajo
                        if (i == 18 && matriz[i][j + 1] instanceof Rebeldes && matriz[i][j - 1] instanceof Rebeldes) {
                            matriz[i][j] = new EspacioEnBlanco();
                            System.out.println("Rebeldes comio en: i=" + i + " j=" + j);
                        }
                    }
                    if (i > 0 && i < 18 && j == 0) {//costado izquierdo
                        if (matriz[i + 1][j] instanceof Rebeldes && matriz[i - 1][j] instanceof Rebeldes) {
                            matriz[i][j] = new EspacioEnBlanco();
                            System.out.println("Rebeldes comio en: i=" + i + " j=" + j);
                        }

                    }
                    if (i > 0 && i < 18 && j == 18) {//costado derecho
                        if (matriz[i + 1][j] instanceof Rebeldes && matriz[i - 1][j] instanceof Rebeldes) {
                            matriz[i][j] = new EspacioEnBlanco();
                            System.out.println("Rebeldes comio en: i=" + i + " j=" + j);
                        }
                    }
                }
            }
        }
    }

}
