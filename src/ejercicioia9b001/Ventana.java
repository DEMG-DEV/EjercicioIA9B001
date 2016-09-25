/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioia9b001;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author ragamz
 */
public class Ventana extends JFrame implements ActionListener {

    private Robot robot;
    private List<Objeto> objetos;
    private Objeto bateria;

    private Objeto almacen;

    private Grafico graf;
    private Timer timer;

    public Ventana() {
        setTitle("Maquina de Estados Finitos");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        init();

        timer = new Timer(10, this);
        timer.start();

        add(graf);
    }

    private void init() {
        objetos = new ArrayList();
        for (int i = 0; i < 10; i++) {
            objetos.add(new Objeto(String.valueOf(i)));
        }
        bateria = new Objeto("Bateria");
        almacen = new Objeto("Almacen");
        robot = new Robot(objetos, bateria, almacen);
        graf = new Grafico(objetos, robot, bateria, almacen);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        robot.control();
        graf.repaint();
        if (!robot.isVivo()) {
            timer.stop();
        }
    }
}
