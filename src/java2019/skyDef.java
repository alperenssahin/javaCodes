package java2019;

import java.awt.*;
import java.awt.event.*;
class Position{
	int x,y;
	public Position(int x,int y) {
		// TODO Auto-generated constructor stub
	this.x = x;
	this.y = y;
	}
}
class kanvas02 extends Canvas implements KeyListener {
    
	Position ucak;
	Position tank;
	Position bomb;
	Position namlu;
	int generator;
    
    public kanvas02() {
        setBackground(Color.white);
        ucak = new Position(10,20);
        generator = (int) (Math.random()*750+50);
        tank = new Position(generator,350);
        bomb = new Position(generator,350);
        namlu = new Position(generator+25,320);
    }

    public void paint(Graphics p) {
       p.setColor(Color.black);
    	p.drawLine(0, 400, 800, 400);
    	
    	try{
    	   Thread.sleep(10);
       }catch(Exception ex){
    	   
       }
    	repaint();

    }

    
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

   
   
}

public class skyDef implements WindowListener {
    private Frame a;
    private kanvas02 k;

    public skyDef() {
        a = new Frame();
        k = new kanvas02();
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