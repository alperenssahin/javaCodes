package java2019;

import java.awt.*;
import java.awt.event.*;

public class sifrele implements WindowListener, ActionListener {
    Frame a;
    Panel b;
    TextArea t1,t2;
    Button d1,d2;
    String abc = "abcçdefghğijklmnoöprsştuüvyzABCÇDEFGHIİJKLMNOÖPRSŞTUÜVYZ";
    String[] cba = new String[56];
    public sifrele() {
        a = new Frame();
        b = new Panel();
        t1 = new TextArea(10,30);
        

        b.add(t1);
        d1 = new Button("Sifrele");
        d2 = new Button("Sifre C�z");

        b.add(d1);
        b.add(d2);
        t2 = new TextArea(10,30);
        b.add(t2);

        b.setBackground(Color.yellow);
        a.add(b);
        d1.addActionListener(this);
        d2.addActionListener(this);

        a.addWindowListener(this);
        a.pack();
        a.setSize(800, 450);
        a.setResizable(false);
        a.setVisible(true);
        
        keyGenerator();
        System.out.println(abc);
        for(int i =0; i<56;i++){
        	System.out.print(cba[i]);
        }
    }
    
    public void keyGenerator(){
    	int abcLength = abc.length();
    	for(int i = 0; i<abcLength; i++){
    		while(true){
    			int randomNum = (int) (Math.random()*56);
    			if(cba[randomNum] == null){
    				cba[randomNum] = abc.substring(i,i+1);
    				break;
    			}else{
    				continue;
    			}
    		}
    	}
		//System.out.println(abc.indexOf("b"));

    	
    }
    public String sifreCoz(String str){
    	String txt = "";
    	int len = str.length();
    	for(int i = 0; i<len; i++){
    		String  s = str.substring(i,i+1);
    		for(int y = 0; y<56;y++){
    			//System.out.println(cba[y] + " " + y + " "+s);
    			if(cba[y].equals(s)){
    				//System.out.println(cba[y] + " -----------------" + y);
    				txt = txt.concat(abc.substring(y,y+1));
    			}
    		}
    	}
    	return txt;
    }
    public String sifreKoy(String str){
    	int ln = str.length();
    	String cripto = "";
    	for (int i=0;i<ln;i++){
    		String karakter = str.substring(i,i+1);
    		int index = abc.indexOf(karakter);
    		cripto = cripto.concat(cba[index]);
    	}
    	return cripto;
    }
    
    public static void main(String args[]) {
        sifrele uygulama = new sifrele();
        //String ex = uygulama.sifreKoy("alperen");	
        //System.out.println(ex);
    }

    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == d1){
    	   //�ifrele
    	   String txt = t1.getText();
    	   t2.setText(sifreKoy(txt));
    	   
       }
       if(e.getSource() == d2){
    	   //sifrec�z  
    	   String txt = t2.getText();
    	   t1.setText(sifreCoz(txt));
       }
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