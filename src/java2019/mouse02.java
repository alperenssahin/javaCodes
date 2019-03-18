package java2019;

import java.awt.*;
import java.awt.event.*;

class kanvas02 extends Canvas implements MouseListener, MouseMotionListener {
    private Point m;
    int x = 200;
    int y = 200;
    int r = 150;
    boolean pressed = false;
    int[] pressedPosition = new int[2];
    boolean inCirc = false;

    public kanvas02() {
        setBackground(Color.yellow);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics p) {
//        p.drawString(m.x+" , "+m.y,m.x,m.y);
        p.setColor(Color.red);
        p.fillOval(x, y, r * 2, r * 2);

    }

    public boolean inCircle() {
        int a = ((m.x - (x + r)) * (m.x - (x + r)));
        int b = ((m.y - (y + r)) * (m.y - (y + r)));
        double d = Math.sqrt(a + b);
        if (d < r) {
            return true;
        } else {
            return false;
        }
    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        this.pressedPosition[0] =  e.getPoint().x- x;
        this.pressedPosition[1] =  e.getPoint().y -y;
//        System.out.println(this.pressedPosition[0]);
    }

    public void mouseDragged(MouseEvent e) {
        m = e.getPoint();
        if (inCircle()) {
            this.x = m.x - this.pressedPosition[0] ;
            this.y = m.y - this.pressedPosition[1] ;
            repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {
        this.pressedPosition[0] =  e.getPoint().x- x;
        this.pressedPosition[1] =  e.getPoint().y -y;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}

public class mouse02 implements WindowListener {
    private Frame a;
    private kanvas02 k;

    public mouse02() {
        a = new Frame();
        k = new kanvas02();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(800, 600);
        a.setResizable(false);
        a.setVisible(true);

    }

    public static void main(String args[]) {

        mouse02 uygulama = new mouse02();
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
