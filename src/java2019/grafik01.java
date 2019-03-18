package java2019;

import java.awt.*;
import java.awt.event.*;

class kanvas extends Canvas {
    int merX = 0;
    int habaY = 600;

    public kanvas() {
        setBackground(Color.yellow);
    }

    public void paint(Graphics p) {

        p.drawString("mer", merX, 300);
        p.drawString("haba",595,habaY);
        if(habaY != 300){
            habaY=habaY-20;
        }
        if(merX <= 560){
            merX = merX+575/15;
        }
        try {
            Thread.sleep(50);
        } catch (Exception e) {

        }
        repaint();
    }
}

public class grafik01 implements WindowListener {
    private Frame a;
    private kanvas k;

    public grafik01() {
        a = new Frame();
        k = new kanvas();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(800, 600);
        a.setResizable(false);
        a.setVisible(true);
    }

    public static void main(String args[]) {
        grafik01 uygulama = new grafik01();
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

}
