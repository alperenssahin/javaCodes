package salı9nisan;


import pers04Nisan.Ball;

import java.awt.*;
import java.awt.event.*;

class Position {
    int x, y, w, h;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class TextPosition{
    String s;
    int x,y;
    int state;
    TextPosition(String s,int x, int y,int state){
        this.x = x;
        this.y = y;
        this.s = s;
        this.state =state;
    }
}
class bCanvas extends Canvas {
    TextPosition[] text;
    Position rect;
    bCanvas() {

        setBackground(Color.white);
        text =new TextPosition[9];
        text[0] = new TextPosition("M",250,150,1);
        text[1] = new TextPosition("E",262,150,1);
        text[2] = new TextPosition("R",270,150,1);
        text[3] = new TextPosition("H",280,150,1);
        text[4] = new TextPosition("A",290,150,1);
        text[5] = new TextPosition("B",300,150,1);
        text[6] = new TextPosition("A",310,150,1);


        rect = new Position(200,150);
        rect.w = 400;
        rect.h = 150;


    }

    public void paint(Graphics p) {
        p.setColor(Color.red);
        p.fillRect(rect.x,rect.y,rect.w,rect.h);
        p.setColor(Color.black);
        updateBall();
        for(int i= 0;i<7;i++){
            if(text[i].state == 2){
                p.drawString(text[i].s,text[i].x-10,text[i].y);
            }else if(text[i].state == 3){
                p.drawString(text[i].s,text[i].x,text[i].y+10);
            }else{
                p.drawString(text[i].s,text[i].x,text[i].y);
            }

        }

        try {
            Thread.sleep(10);
        } catch (Exception ex) {

        }
        repaint();
    }
    public void updateBall(){
        for(int i = 0; i<7;i++){
            if(text[i].x == rect.x && text[i].y ==rect.y){
                text[i].state = 2;
            }
            if(text[i].x == rect.x && text[i].y == rect.y+rect.h){
                text[i].state = 3;
            }
            if(text[i].x == rect.x+rect.w && text[i].y ==rect.y+rect.h){
                text[i].state = 4;
            }
            if(text[i].x == rect.x+rect.w  && text[i].y ==rect.y){
                text[i].state = 1;
            }
            if(text[i].state == 1){
                text[i].x--;
            }
            if(text[i].state == 2){
                text[i].y++;
            }
            if(text[i].state == 3){
                text[i].x++;
            }
            if(text[i].state == 4){
                text[i].y--;
            }
        }


    }


}

public class ballMove implements WindowListener {
    private Frame a;
    private bCanvas k;

    public ballMove() {
        a = new Frame();
        k = new bCanvas();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(800, 500);
        a.setResizable(false);
        a.setVisible(true);
    }

    public static void main(String[] args) {
        ballMove oyun = new ballMove();
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
