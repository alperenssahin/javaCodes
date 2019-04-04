package salı02Nisan;

public class sirala {

    public static void main(String args[]){
        int[] dizi = new int[]{7,3,10,1,6};
        int[] index = new int[]{0,0,0,0,0};
        for(int i = 0; i<dizi.length; i++){
            for(int y = i; y<dizi.length;y++){
                if(dizi[i] > dizi[y]){
                    index[i]++;
                }else{
                    index[y]++;
                }
            }
        }
//        int[] nDizi = new int[5];
//        for(int i = 0; i<dizi.length;i++){
//           nDizi[index[i]] = dizi[i];
//        }
//        for(int i = 0; i<dizi.length;i++){
//            System.out.println(nDizi[i]);
//        }

    }
}
