package java2019v2;

import java.awt.*;
import java.awt.event.*;
class position{
    int x,y;
    position(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class kanvas02 extends Canvas implements KeyListener {
    int x = 400, y = 300;
    position man;
    position ucak;
    position bomb;
    int time = 0;
    int clock = 0;
    boolean bombed = false;

    public kanvas02() {
        setBackground(Color.cyan);
        addKeyListener(this);
        int starterPosition = (int) (Math.random()*700 + 50);
        man = new position(starterPosition,350);
        ucak = new position(10,20);
        bomb = new position(0,0);
    }

    public void paint(Graphics p) {
        p.drawLine(0,400,800,400);
        p.setColor(Color.red);
        p.fillRect(man.x,man.y,50,50);
        p.setColor(Color.black);
        p.fillRect(ucak.x,ucak.y,80,45);
        p.setColor(Color.black);

        if(isCol()){ Font tt = new Font("Times New Roman", Font.PLAIN, 40);
        p.setFont(tt);
        p.drawString("Tebrikler Kazandız!!!", 350, 200);
//            try{
//                Thread.sleep(2000);
//                System.exit(0);
//            }catch (Exception ex){
//
//            }
        }
        if(ucak.x > 800){
            ucak.x = -80;
            this.bombed = false;
            this.time = 0;
        }else{
            ucak.x = ucak.x + 1;
            if(this.bombed){
                this.time++;
                clock++;
                if(bomb.y < 415){
                p.setColor(Color.red);
                p.fillOval(bomb.x,bomb.y,15,15);
                bomb.x =  bomb.x+2;
                bomb.y = ucak.y + 45 + time*time/100;
                }
            }
        }


        try{
            Thread.sleep(10);
        }catch (Exception ex){

        }
        repaint();
    }
    public boolean isCol(){
        return bomb.x > man.x - 15 && bomb.x < man.x + 50 && bomb.y < man.y - 15;
    }
    public void keyPressed(KeyEvent e) {
        int tus = e.getKeyCode();
        switch (tus) {
            case (KeyEvent.VK_DOWN):
                if(!this.bombed){
                    this.bomb.x = ucak.x+80;
                    this.bomb.y = ucak.y+45;
                    this.bombed = true;
                }
                break;

        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}

public class klavye01 implements WindowListener {
    private Frame a;
    private kanvas02 k;

    public klavye01() {
        a = new Frame();
        k = new kanvas02();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(800, 450);
        a.setResizable(false);
        a.setVisible(true);
    }

    public static void main(String args[]) {

        klavye01 uygulama = new klavye01();
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