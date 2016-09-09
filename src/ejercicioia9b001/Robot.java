/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioia9b001;

import java.util.List;
import java.util.Random;

/**
 *
 * @author ragamz
 */
public class Robot {

    private int x;
    private int y;

    private int energia;
    private List<Objeto> objetos;
    private Objeto bateria;

    private Objeto objetoActual;

    private boolean vivo;

    private enum estados {
        BUSQUEDA, NUEVA_BUSQUEDA, IR_BATERIA, RECARGA, MUERTO, ALEATORIO
    };

    private estados estadoActual;

    public Robot(List<Objeto> objetos, Objeto bateria) {
        this.x = 320;
        this.y = 240;
        this.energia = 800;
        this.objetos = objetos;
        this.bateria = bateria;
        this.objetoActual = null;
        this.estadoActual = estados.NUEVA_BUSQUEDA;
        this.vivo = true;
    }

    public void control() {
        switch (estadoActual) {
            case BUSQUEDA:
                if (x < objetoActual.getX()) {
                    x++;
                } else if (x > objetoActual.getX()) {
                    x--;
                }
                if (y < objetoActual.getY()) {
                    y++;
                } else if (y > objetoActual.getY()) {
                    y--;
                }
                energia--;
                if (x == objetoActual.getX() && y == objetoActual.getY()) {
                    objetoActual.setActivo(false);
                    estadoActual = estados.NUEVA_BUSQUEDA;
                } else if (energia < 350) {
                    estadoActual = estados.IR_BATERIA;
                }
                break;
            case NUEVA_BUSQUEDA:
                objetoActual = null;
                Objeto objetoActualMe = null;
                double d = 0.0;
                d = 1000;
                for (Objeto o : objetos) {
                    double dist = Math.sqrt(Math.pow(o.getX() - getX(), 2) + Math.pow(o.getY() - getY(), 2));
                    if (dist < d && o.isActivo()) {
                        d = dist;
                        objetoActualMe = o;
                    }
                }
                objetoActual = objetoActualMe;
                if (objetoActual == null) {
                    estadoActual = estados.ALEATORIO;
                } else {
                    estadoActual = estados.BUSQUEDA;
                }
                break;
            case IR_BATERIA:
                if (x < bateria.getX()) {
                    x++;
                } else if (x > bateria.getX()) {
                    x--;
                }
                if (y < bateria.getY()) {
                    y++;
                } else if (y > bateria.getY()) {
                    y--;
                }
                energia--;
                if (x == bateria.getX() && y == bateria.getY()) {
                    estadoActual = estados.RECARGA;
                } else if (energia == 0) {
                    estadoActual = estados.MUERTO;
                }
                break;
            case RECARGA:
                energia = 1000;                
                estadoActual = estados.NUEVA_BUSQUEDA;
                break;
            case ALEATORIO:
                energia--;
                Random r = new Random();
                x += r.nextInt(2) == 0 ? 1 : -1;
                y += r.nextInt(2) == 0 ? 1 : -1;
                if (energia == 0) {
                    estadoActual = estados.MUERTO;
                }
                break;
            case MUERTO:
                vivo = false;
                break;
        }
    }

    public estados getEstadoActual() {
        return estadoActual;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getEnergia() {
        return energia;
    }

    public boolean isVivo() {
        return vivo;
    }
}
