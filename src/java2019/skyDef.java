package java2019;

import java.awt.*;
import java.awt.event.*;

class Position {
    int x, y;

    public Position(int x, int y) {
        // TODO Auto-generated constructor stub
        this.x = x;
        this.y = y;
    }
}

class playGround extends Canvas implements KeyListener {

    Position ucak;
    Position tank;
    Position bomb;
    Position namlu;
    int generator;
    double angle = Math.PI/2;
    private boolean leftPress = false;
    private boolean rightPress = false;
    private boolean bombed = false;
    int xDif,yDif;
    double m,a;



    public playGround() {
        addKeyListener(this);
        setBackground(Color.white);
        ucak = new Position(10, 20);
        generator = (int) (Math.random() * 750 + 50);
        tank = new Position(generator, 350);
        bomb = new Position(generator, 350);
        namlu = new Position(generator + 25, 320);
    }

    public void paint(Graphics p) {
        p.setColor(Color.black);
        p.drawLine(0, 400, 800, 400);
        p.fillRect(ucak.x, ucak.y, 80, 45);
        p.setColor(Color.red);
        p.fillRect(tank.x, tank.y, 50, 50);
        p.setColor(Color.black);
        p.drawLine(tank.x + 25, tank.y, namlu.x, namlu.y);
        p.setColor(Color.red);
        p.fillOval(tank.x+20,tank.y-5,10,10);

        if (ucak.x < 800) {
            ucak.x++;
        } else {
            ucak.x = -80;
        }

        if (this.rightPress) {
            if (this.angle <= 0) {
                this.angle = 0;
            } else {
                this.angle = this.angle - 0.1;
            }
        }
        if (this.leftPress) {
            if (this.angle >= Math.PI) {
                this.angle = Math.PI;
            } else {
                this.angle= this.angle + 0.1;
            }
        }
        this.namlu.x = tank.x + 25 + (int) (30 * (Math.cos(angle)));
        this.namlu.y = tank.y - (int) (30 * (Math.sin(angle)));

        if(this.bombed){
            p.drawLine(bomb.x,bomb.y,bomb.x-xDif,bomb.y-yDif);
            if(this.m >= 0){
                bomb.x-=2;
            }else{
                bomb.x+=2;
            }
            yGen();
            if(bomb.y < 0 || bomb.y > 450 || bomb.x > 800 || bomb.x < 0){
                this.bombed = false;
            }
        }
//        System.out.println(angle);
        try {
            Thread.sleep(10);
        } catch (Exception ex) {

        }
        repaint();

    }

    public void yGen(){
            this.bomb.y = (int)(this.m*this.bomb.x+this.a);
    }
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int tus = e.getKeyCode();
        switch (tus) {
            case (KeyEvent.VK_UP):
                    if(!this.bombed){
                        this.bombed = true;
                        this.bomb.x = this.namlu.x;
                        this.bomb.y = this.namlu.y;
                        this.xDif = this.generator +25 - this.bomb.x;
                        this.yDif = this.tank.y - this.bomb.y;
                        this.m = (double) yDif/xDif;
                        this.a = this.bomb.y - m * this.bomb.x;
                    }
                break;
            case (KeyEvent.VK_LEFT):
                this.leftPress = true;
                break;
            case (KeyEvent.VK_RIGHT):
                this.rightPress = true;
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        int tus = e.getKeyCode();
        switch (tus) {
            case (KeyEvent.VK_DOWN):
                break;
            case (KeyEvent.VK_LEFT):
                this.leftPress = false;
                break;
            case (KeyEvent.VK_RIGHT):
                this.rightPress = false;
                break;
        }
    }

    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }


}

public class skyDef implements WindowListener {
    private Frame a;
    private playGround k;

    public skyDef() {
        a = new Frame();
        k = new playGround();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(800, 450);
        a.setResizable(false);
        a.setVisible(true);

    }

    public static void main(String args[]) {

        skyDef uygulama = new skyDef();
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