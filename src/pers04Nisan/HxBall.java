package pers04Nisan;

import java.awt.*;
import java.awt.event.*;

class Position {
    int x, y, w, h;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class hxCanvas extends Canvas implements KeyListener {
    Position ball;
    Position player1, player2;
    int vitesseX, vitesseY;
    int ecranW, ecranH;
    int goalSpace;
    boolean gk1_up, gk1_down, gk2_up, gk2_down;
    int score1,score2;
    hxCanvas(int w, int h) {
        score1 = 0;
        score2 = 0;
        gk1_up = false;
        gk1_down = false;
        gk2_up = false;
        gk2_down = false;
        this.ecranH = h;
        this.ecranW = w;
        this.goalSpace = 50;
        setBackground(Color.white);
        addKeyListener(this);
        player1 = new Position(goalSpace + 30, ecranH / 4);
        player1.w = 20;
        player1.h = 80;
        player2 = new Position(ecranW - (goalSpace + 30 + 20), ecranH / 4);
        player2.w = 20;
        player2.h = 80;


        ball = new Position(ecranW/2, ecranH/2);

        ball.w = 20;
        ball.h = 20;
        while (true) {
            double rand = Math.random() * Math.PI * 2;
            System.out.println(rand);
            int v = (int) (Math.random() * 10);
            vitesseX = (int) (v * Math.cos(rand));
            vitesseY = (int) (v * Math.sin(rand));
            if ((vitesseY > 1 || vitesseY < -1) && (vitesseX > 1 || vitesseX < -1)) {
                break;
            }
        }
    }

    public void paint(Graphics p) {
        p.setColor(Color.red);
        p.fillOval(ball.x, ball.y, ball.w, ball.h);
        p.setColor(Color.black);
        p.drawLine(goalSpace, 0, goalSpace, ecranH);
        p.drawLine(ecranW - goalSpace, 0, ecranW - goalSpace, ecranH);
        p.fillRect(player1.x, player1.y, player1.w, player1.h);
        p.fillRect(player2.x, player2.y, player2.w, player2.h);
        p.drawString("p1:"+score1,10,10);
        p.drawString("p2:"+score2,ecranW-40,10);

        updateBall();
        updateGoalkeeper();
        try {
            Thread.sleep(20);
        } catch (Exception ex) {

        }
        repaint();
    }

    public void updateBall() {
        ball.x += vitesseX;
        ball.y += vitesseY;
        if (ball.y <= 0) {
            vitesseY *= (-1);
        }
        if (ball.y >= ecranH - 2 * ball.h) {
            vitesseY *= (-1);
        }
        if (ball.x >= ecranW - ball.w - goalSpace) {
            vitesseX *= (-1);
            score1++;
            resetBall();
        }
        if (ball.x <= goalSpace) {
            vitesseX *= (-1);
            score2++;
            resetBall();
        }
        if(ball.x <= player1.x+player1.w && (ball.y <= player1.y+player1.h && ball.y >= player1.y )){
            vitesseX *= (-1);
        }
        if(ball.x >= player2.x - ball.w && (ball.y <= player2.y+player2.h && ball.y >= player2.y )){
            vitesseX *= (-1);
        }
    }

    public void updateGoalkeeper() {
        int vitesse = 10;
        if (gk1_down) {
            if (player1.y <= ecranH - player1.h - 20) {
                player1.y += vitesse;
            }
        }
        if (gk1_up) {
            if (player1.y >= 0) {
                player1.y -= vitesse;
            }
        }
        if (gk2_down) {
            if (player2.y <= ecranH - player2.h - 20) {
                player2.y += vitesse;
            }
        }
        if (gk2_up) {
            if (player2.y >= 0) {
                player2.y -= vitesse;
            }
        }
    }
    public void resetBall(){
        ball.x = ecranW/2;
        ball.y = ecranH/2;
    }
    public void keyPressed(KeyEvent e) {
        int tus = e.getKeyCode();
        switch (tus) {
            case (KeyEvent.VK_DOWN):
                gk2_down = true;
                break;
            case (KeyEvent.VK_UP):
                gk2_up = true;
                break;
            case (KeyEvent.VK_A):
                gk1_up = true;
                break;
            case (KeyEvent.VK_Z):
                gk1_down = true;
                break;

        }
    }

    public void keyReleased(KeyEvent e) {
        int tus = e.getKeyCode();
        switch (tus) {
            case (KeyEvent.VK_DOWN):
                gk2_down = false;
                break;
            case (KeyEvent.VK_UP):
                gk2_up = false;
                break;
            case (KeyEvent.VK_A):
                gk1_up = false;
                break;
            case (KeyEvent.VK_Z):
                gk1_down = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }
}

public class HxBall implements WindowListener {
    private Frame a;
    private hxCanvas k;

    public HxBall() {
        a = new Frame();
        k = new hxCanvas(800, 450);
        a.addWindowListener(this);
        a.add(k);
        a.setSize(800, 450);
        a.setResizable(false);
        a.setVisible(true);
    }

    public static void main(String[] args) {
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
