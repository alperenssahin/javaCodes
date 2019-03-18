package java2019;

import java.awt.*;
import java.awt.event.*;

public class exchange implements WindowListener, ActionListener {

    Frame a;
    Panel panel;
    TextField inTL,inUSD;
    Button buttonTL ,buttonUSD;
    Label labelTL,labelUSD;

    public exchange() {
        a = new Frame();

        panel = new Panel();
        labelTL = new Label("Tl:");
        panel.add(labelTL);
        inTL = new TextField(30);
        panel.add(inTL);
        buttonTL = new Button("$ Çevir");
        panel.add(buttonTL);
        panel.setBackground(Color.yellow);
        buttonTL.addActionListener(this);
        inUSD = new TextField(30);
        labelUSD = new Label("$:");
        panel.add(labelUSD);
        panel.add(inUSD);
        buttonUSD = new Button("Tl Çevir");
        panel.add(buttonUSD);
        panel.setBackground(Color.yellow);
        a.add(panel);

        buttonUSD.addActionListener(this);

        a.addWindowListener(this);
        a.pack();
        a.setSize(385, 225);
        a.setResizable(false);
        a.setVisible(true);
    }

    public static void main(String args[]) {
        exchange uygulama = new exchange();

    }


    public void actionPerformed(ActionEvent e) {
        String tl = inTL.getText();
        String  usd = inUSD.getText();
        double numTl = 0,numUsd = 0;
        try {
            numTl = Double.parseDouble(tl);
            numUsd = Double.parseDouble(usd);
        } catch (Exception ex) {
            System.out.println("Lütfen sadece rakkam girdiğinizden emin olun..!!!");
        }
        if(e.getSource() == buttonTL){

            inUSD.setText(String.valueOf(numTl/5.4));
        }
        if(e.getSource() == buttonUSD){
            inTL.setText(String.valueOf(numUsd*5.4));
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
