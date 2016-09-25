/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioia9b001;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author ragamz
 */
public class Grafico extends JPanel {

    private List<Objeto> objetos;
    private Robot robot;
    private Objeto bateria;

    private Objeto almacen;

    public Grafico(List<Objeto> objetos, Robot robot, Objeto bateria, Objeto almacen) {
        this.objetos = objetos;
        this.robot = robot;
        this.bateria = bateria;
        this.almacen = almacen;
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.drawString("Energía: " + robot.getEnergia(), 10, 10);
        g2d.drawString("Estado: " + robot.getEstadoActual(), 100, 10);

        // objetos
        g2d.setColor(Color.WHITE);
        for (Objeto o : objetos) {
            if (o.isActivo()) {
                g2d.drawString(o.getId(), o.getX(), o.getY() - 5);
                g2d.fillRect(o.getX(), o.getY(), 10, 10);
            }
        }

        // bateria
        g2d.setColor(Color.GREEN);
        g2d.drawString(bateria.getId(), bateria.getX(), bateria.getY() - 5);
        g2d.fillRect(bateria.getX(), bateria.getY(), 10, 10);

        // almacen
        g2d.setColor(Color.BLUE);
        g2d.drawString(almacen.getId(), almacen.getX(), almacen.getY() - 5);
        g2d.fillRect(almacen.getX(), almacen.getY(), 10, 10);
        
        // robot
        g2d.setColor(Color.RED);
        g2d.fillRect(robot.getX(), robot.getY(), 10, 10);

        g2d.dispose();
    }
}
