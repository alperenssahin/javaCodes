package java2019;
import java.awt.*;
import java.awt.event.*;

class kanvas01 extends Canvas implements MouseListener,MouseMotionListener{
    private Point m;
    int dY = 350;
    int dX = 350;
    int dR = 150;
    public kanvas01()
    {
        setBackground(Color.yellow);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void paint(Graphics p){
//        p.drawString(m.x+" , "+m.y,m.x,m.y);

        int a = (m.x-dX)*(m.x-dX);
        int b = (m.y-dY)*(m.y-dY);
        double dis = Math.sqrt(a+b);
        if (dis < dR && dis > 75){
            p.setColor(Color.red);
            p.fillOval(200,200,300,300);
            p.setColor(Color.yellow);
            p.fillOval(275,275,150,150);
            setBackground(Color.yellow);
        }else{
            p.setColor(Color.yellow);
            p.fillOval(200,200,300,300);
            p.setColor(Color.red);
            p.fillOval(275,275,150,150);
            setBackground(Color.red);
        }


    }
    public void mouseMoved(MouseEvent e){
        m = e.getPoint();
        repaint();
    }
    public void mousePressed(MouseEvent e){}

    public void mouseDragged(MouseEvent e){}

    public void mouseReleased(MouseEvent e){}

    public void mouseClicked(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}

}

public class mouse01 implements WindowListener{
    private Frame a;
    private kanvas01 k;

    public mouse01(){
        a = new Frame();
        k = new kanvas01();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(800,600);
        a.setResizable(false);
        a.setVisible(true);

    }
    public static void main(String args[]){
        mouse01 uygulama = new mouse01();
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
