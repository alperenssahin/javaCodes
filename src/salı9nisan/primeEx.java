package salı9nisan;

public class primeEx {

    public static void main(String[] args){
        for(int i=1000; i<9999;i++){
            if(superPrime(i)){
                System.out.println(i + " super Prime :" + superPrime(i));
            }
        }

    }
    public static boolean superPrime(int n){
        if( n < 10 && isPrime(n) && n != 0 ){
            return true;
        }else if(isPrime(n) && n != 0 && superPrime((n-(n%10))/10)){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isPrime(int n){
        if(n <= 1) return false;
        boolean prime = true;
        for(int i = 2; i<n;i++){
            if(n%i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }
}
