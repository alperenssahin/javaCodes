package pers04Nisan;

import java.awt.*;
import java.awt.event.*;

class Position{
    int x,y,w,h;

    Position(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class hxCanvas  extends Canvas implements KeyListener {
    Position ball;
    int vitesseX,vitesseY;
    hxCanvas(){
        setBackground(Color.white);
        addKeyListener(this);
        int x = (int)(Math.random()*650+50);
        int y = (int)(Math.random()*650+50);
        ball = new Position(x,y);
        ball.w = 20;
        ball.h = 20;
        while (true){
            double rand = Math.random()*Math.PI*2;
            System.out.println(rand);
            int v  = (int)(Math.random()*10);
            vitesseX = (int)(v*Math.cos(rand));
            vitesseY = (int)(v*Math.sin(rand));
            if((vitesseY > 1 || vitesseY < -1 )&& (vitesseX > 1 || vitesseX < -1)){
                break;
            }
        }
    }
    public void paint(Graphics p){
        p.setColor(Color.red);
        p.fillOval(ball.x,ball.y,ball.w,ball.h);
        p.setColor(Color.black);
    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {
    }
}
public class HxBall implements WindowListener {
    private Frame a;
    private hxCanvas k;
    public HxBall(){
        a = new Frame();
        k = new hxCanvas();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(800, 450);
        a.setResizable(false);
        a.setVisible(true);
    }
    public static void main(String[] args){
        HxBall oyun = new HxBall();
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
