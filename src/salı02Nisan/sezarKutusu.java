package salı02Nisan;

import java.awt.*;
import java.awt.event.*;

public class sezarKutusu implements WindowListener, ActionListener {
    Frame a;
    Panel b;
    TextArea t1,t2;
    Button d1,d2;
    String[][] list;
    String key = "";
    String gen = "";
    int size;
    public sezarKutusu() {
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


    }

    public void textOperation(String  str){
        int len = str.length();
        size = (int) Math.sqrt(len);
        if(len %size != 0){
            size ++;
        }
        list = new String[size][size];
        int pitch = size;
        for(int i = 0; i<size; i++){
            for(int y =0; y<size; y++){
                if(y+pitch*i >= len) break;
                list[i][y] = str.substring(y+pitch*i,y+pitch*i+1);
            }
        }
        printList();
    }
    public void keyGen(){
        for(int i = 0; i<size; i++){
            for(int y =0; y<size; y++){
                if(list[y][i] == null){
                    continue;
                }
                key += list[y][i];
            }
        }
    }
    public void genKey(){
        for(int i = 0; i<size; i++){
            for(int y =0; y<size; y++){
                if(list[i][y] == null){
                    continue;
                }
                gen += list[i][y];
            }
        }
    }
    public void printList(){
        for(int i = 1; i<size+1; i++){
            for(int y =1; y<size+1; y++){
                System.out.print(list[y-1][i-1] + " ");
            }
            System.out.println();
        }
    }




    public static void main(String args[]) {
        sezarKutusu uygulama = new sezarKutusu();

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == d1){
            //�ifrele
            key = "";
            String txt = t1.getText();
            textOperation(txt);
            keyGen();
            t2.setText(key);

        }
        if(e.getSource() == d2){
            //sifrec�z
            gen ="";
            String txt = t2.getText();
            genKey();
            t1.setText(gen);

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
