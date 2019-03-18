package java2019;

class rasyonelSayi {
    int pay;
    int payda;

    public rasyonelSayi(int pay, int payda) {
        if (payda == 0) {
            System.out.println(pay + "/" + payda + " Geçerli bir rasyonel sayı değil");
            return;
        }
        this.pay = pay;
        this.payda = payda;
    }

    public void print() {
        System.out.println(this.pay + "/" + this.payda);
    }

    public static rasyonelSayi carp(rasyonelSayi a, rasyonelSayi b) {
        int payR = a.pay * b.pay;
        int paydaR = a.payda * b.payda;
        rasyonelSayi res = new rasyonelSayi(payR, paydaR);
        return res;
    }

    public static rasyonelSayi bol(rasyonelSayi a, rasyonelSayi b) {
        int payR = a.pay * b.payda;
        int paydaR = a.payda * b.pay;
        rasyonelSayi res = new rasyonelSayi(payR, paydaR);
        return res;
    }

    public static rasyonelSayi topla(rasyonelSayi a, rasyonelSayi b) {
        int payR = (a.pay * b.payda) + (a.payda * b.pay);
        int paydaR = a.payda * b.payda;
        rasyonelSayi res = new rasyonelSayi(payR, paydaR);
        return res;
    }

    public static rasyonelSayi cikar(rasyonelSayi a, rasyonelSayi b) {
        int payR = (a.pay * b.payda) - (a.payda * b.pay);
        int paydaR = a.payda * b.payda;
        rasyonelSayi res = new rasyonelSayi(payR, paydaR);
        return res;
    }
    public void sadelestir(){
        int max = this.payda;
        if(this.pay > this.payda){
            max = this.pay;
        }
        for(int i = 2; i<max; i++){
            if(this.pay%i == 0 && this.payda%i == 0){
                this.pay = this.pay/i;
                this.payda = this.payda/i;
            }
        }
    }
}

public class rasyonelNum {
    public static void main(String args[]) {
        rasyonelSayi sayi1 = new rasyonelSayi(1, 4);
        rasyonelSayi sayi2 = new rasyonelSayi(1, 2);
        sayi1.print();
        sayi2.print();
        rasyonelSayi carpimSonnuc = rasyonelSayi.carp(sayi1, sayi2);
        System.out.println("Çarpım:");
        carpimSonnuc.print();
        rasyonelSayi bolumSonuc = rasyonelSayi.bol(sayi1,sayi2);
        System.out.println("Bolum:");
        bolumSonuc.sadelestir();
        bolumSonuc.print();
        rasyonelSayi farkSonuc = rasyonelSayi.cikar(sayi1,sayi2);
        System.out.println("Fark:");
        farkSonuc.print();
        rasyonelSayi toplamSonuc = rasyonelSayi.topla(sayi1,sayi2);
        System.out.println("Toplam");
        toplamSonuc.print();

    }
}
