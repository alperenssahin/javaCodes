//package java2019v2;
//
//public class romaNumber {
//
//    public static void main(String args[]){
//        romaCevir(2984);
//    }
//
//    public static String romaCevir(int n){
//        String roma ="";
//        int[] arr = getDigits(n);
//
//        return roma;
//    }
//    public static String step(int step,int number){
//        switch (step){
//            case(4):
//                break;
//            case(3):
//                break;
//            case(2):
//                break;
//            case(1):
//                break;
//        }
//    }
//    private static int[] getDigits(int num) {
//        int[] digits = new int[4];
//        digits[0] = num % 10;
//        digits[1] = (num % 100 - digits[0]) / 10;
//        digits[2] = (num % 1000 - digits[1] * 10 - digits[0]) / 100;
//        digits[3] = (num % 10000 - digits[2] * 100 - digits[1] * 10 - digits[0]) / 1000;
////        System.out.println(Arrays.toString(digits));
//        return digits;
//    }
//
//}
