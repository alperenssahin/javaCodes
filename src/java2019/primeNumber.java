package java2019;

import java.awt.*;
import java.awt.event.*;

public class primeNumber implements WindowListener, ActionListener {
    Frame a;
    Panel b;
    TextField t;
    Button d;

    public primeNumber() {
        a = new Frame();
        b = new Panel();
        t = new TextField(30);
        b.add(t);
        d = new Button("Ok");
        b.add(d);

        b.setBackground(Color.yellow);
        a.add(b);
        d.addActionListener(this);
        a.addWindowListener(this);
        a.pack();
        a.setSize(400, 225);
        a.setResizable(false);
        a.setVisible(true);
    }

    private void isPrime(int num) {
        boolean check = true;
        if (num <= 1){
            System.out.println("Lütfen geçerli bir sayı giriniz");
            return;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println(num + " bir asal sayıdır");
        } else {
            System.out.println(num + " bir asal sayı değildir");
        }
    }

    public static void main(String args[]) {
        primeNumber uygulama = new primeNumber();

    }

    public void actionPerformed(ActionEvent e) {
        String s = t.getText();
        int num;
        try {
            num = Integer.parseInt(s);
            isPrime(num);
        } catch (Exception ex) {
            System.out.println("Lütfen sadece rakkam girdiğinizden emin olun..!!!");
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
