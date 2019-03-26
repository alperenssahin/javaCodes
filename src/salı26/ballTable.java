package salı26;

import java.awt.*;
import java.awt.event.*;

class Position{
    int x,y;

    Position(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class kanvas02 extends Canvas {
    Position ball;
    int vitesseX,vitesseY;
    Position carpısma;
    boolean inRect;
    boolean app = false;
    int zone;
    public kanvas02() {
        setBackground(Color.white);
        do{
            int x = (int) (Math.random()*650 + 50);
            int y =  (int) (Math.random()*300 + 50);
            ball = new Position(x,y);
            isInRect();
        }while (inRect);
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
        carpısma = new Position(0,0);
        isInRect();
        zone();
    }

    public void paint(Graphics p) {
        p.setColor(Color.red);
        p.fillRect(200,100,400,200);
        p.setColor(Color.black);
        p.fillOval(ball.x,ball.y,50,50);
        move();
        isInRect();
        zone();
        System.out.println(zone);

        try {
            Thread.sleep(30);
        }catch (Exception ex){

        }
        repaint();
        }
    public  void isInRect(){
        if(ball.x >= 200 && ball.x <= 570 && ball.y >=100 && ball.y <=270){
            this.inRect = true;
        }else{
            this.inRect = false;
        }
    }
    public void zone(){
        if(ball.x >= 200 && ball.x <=600 && ball.y <=60 && ball.y >= 0){
            zone = 1;
        }
        if( ball.x >= 150 && ball.x <=600 && ball.y >=300 && ball.y <=450){
            zone = 2;
        }
        if(ball.x >= 0 && ball.x <=150 && ball.y <=300 && ball.y >= 100){
            zone = 3;
        }
        if(ball.x >= 600 && ball.x <=800 && ball.y <=370 && ball.y >= 60){
            zone = 4;
        }
    }
    public void move(){

//        if(inRect){
//            if(!app){
//                vitesseY /= 2;
//                vitesseX /= 2;
//            }
//            app = true;
//        }
//        if(app && !inRect){
//            vitesseY *= 2;
//            vitesseX *= 2;
//            app = false;
//        }
        if(ball.y <= 0 && zone != 2){
            vitesseY *= (-1);
        }
        if(ball.y >=380 && zone != 1){
            vitesseY *= (-1);
        }
        if(ball.x >= 750 && zone != 3){
            vitesseX *= (-1);
        }
        if(ball.x <= 0 && zone != 4){
            vitesseX *= (-1);
        }
        if(ball.y >=50 && (ball.x >= 200 && ball.x <=600) && zone == 1 ){
            vitesseY *= (-1);
        }
        if(ball.y <=300 && (ball.x >= 200 && ball.x <=600)&& zone == 2 ){
            vitesseY *= (-1);
        }
        if(ball.x >=150 && (ball.y >= 100 && ball.y <=300) && zone == 3 ){
            vitesseX *= (-1);
        }
        if(ball.x <=600 && (ball.y >= 100 && ball.y <=300)&& zone == 4 ){
            vitesseX *= (-1);
        }


        ball.x += vitesseX;
        ball.y += vitesseY;
    }


}


public class ballTable implements WindowListener {
    private Frame a;
    private kanvas02 k;

    public ballTable() {
        a = new Frame();
        k = new kanvas02();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(800, 450);
        a.setResizable(false);
        a.setVisible(true);
    }

    public static void main(String args[]) {

        ballTable uygulama = new ballTable();
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
