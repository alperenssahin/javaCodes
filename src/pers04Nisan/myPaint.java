package pers04Nisan;


import java.awt.*;
import java.awt.event.*;

class paintCanvas extends Canvas implements MouseListener,MouseMotionListener {
    boolean pressed = false;
    public paintCanvas(){
        setBackground(Color.yellow);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void mouseMoved(MouseEvent e){

    }
    public void mousePressed(MouseEvent e){
        pressed = true;
        p1 = e.getPoint();
    }
    Point p1;
    Point p2;
    public void mouseDragged(MouseEvent e){
            p2 = e.getPoint();
            Graphics p = getGraphics();
            p.drawLine(p1.x,p1.y,p2.x,p2.y);
            if(p2.x != p1.x || p2.y != p1.y){
                p1.x = p2.x;
                p1.y = p2.y;
            }
    }

    public void mouseReleased(MouseEvent e){
        pressed =false;
    }

    public void mouseClicked(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}
}

public class myPaint implements WindowListener{

    private Frame a;
    private paintCanvas k;

    public myPaint(){
        a = new Frame();
        k = new paintCanvas();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(800,600);
        a.setResizable(false);
        a.setVisible(true);

    }
    public static void main(String args[]){
        myPaint uygulama = new myPaint();
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
