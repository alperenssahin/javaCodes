package java2019;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class sayiBulmaOyunu implements WindowListener, ActionListener {

    Frame a;
    Panel b;
    TextField t;
    Button d;
    int r;

    public sayiBulmaOyunu() {
        a = new Frame();
        b = new Panel();
        t = new TextField(30);
        b.add(t);
        d = new Button("Ok");
        b.add(d);
        do {
            r = ((int) (8999 * Math.random())) + 1000;
            System.out.println("Random : " + r);
        } while (checkNumber(r));

        b.setBackground(Color.yellow);
        a.add(b);
        d.addActionListener(this);
        a.addWindowListener(this);
        a.pack();
        a.setSize(400, 225);
        a.setResizable(false);
        a.setVisible(true);
    }

    public static void main(String args[]) {
        System.out.println("1000 ila 9999 arasında bir sayı giriniz!!");
        sayiBulmaOyunu uygulama = new sayiBulmaOyunu();

    }

    private int[] getDigits(int num) {
        int[] digits = new int[4];
        digits[0] = num % 10;
        digits[1] = (num % 100 - digits[0]) / 10;
        digits[2] = (num % 1000 - digits[1] * 10 - digits[0]) / 100;
        digits[3] = (num % 10000 - digits[2] * 100 - digits[1] * 10 - digits[0]) / 1000;
//        System.out.println(Arrays.toString(digits));
        return digits;
    }

    private boolean checkNumber(int num) {
        int[] a = getDigits(num);
        for (int i = 0; i < 4; i++) {
            for (int y = i + 1; y < 3; y++) {
                if (a[i] == a[y]) {
//                    System.out.println("trig");
                    return true;
                }
            }
        }
        return false;
    }

    private int gamePoint(int num) {
        int[] random = getDigits(r);
        int[] number = getDigits(num);
        int offset = 0;
        for (int i = 0; i < 4; i++) {
            for (int y = 0; y < 4; y++) {

                if (i == y && random[i] == number[y]) {
                    offset++;
                }else{
                if (random[i] == number[y]) {
                    offset--;
                }
                }
//                System.out.println(i + " " + y + " "+ random[i] + " " +number[y] +" offset: "+offset);
            }
        }
        return offset;
    }


    public void actionPerformed(ActionEvent e) {
        String s = t.getText();
        int num;
        try {
            num = Integer.parseInt(s);
            if (num < 1000 || num > 9999) {
                System.out.println("Lütfen belirtilen aralıkta bir değer girin");
                return;
            }
            if (checkNumber(num)) {
                System.out.println("Lütfen girdiğiniz rakkkamların farklı olduğuna dikkat edin");
                return;
            }
            int game = gamePoint(num);
            if(game != 4){
                System.out.println(game);
            }else{
                System.out.println("!!!! Tebrikler Oyunu Kazandınız !!!!");
            }

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
