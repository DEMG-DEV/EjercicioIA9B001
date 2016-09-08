/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioia9b001;

import java.util.Random;

/**
 *
 * @author ragamz
 */
public class Objeto {
    private int x;
    private int y;
    private boolean activo;

    public Objeto() {
        Random r = new Random();
        this.x = r.nextInt(700);
        this.y = r.nextInt(500);
        this.activo = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
