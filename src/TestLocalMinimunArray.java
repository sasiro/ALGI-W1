/**
 * Created by pablo on 22/06/2015.
 */
public class TestLocalMinimunArray {

    public static void main (String[] args){

        for(int j = 0; j < 10; j++) {
            Stopwatch w1 = new Stopwatch();
            int N = 1 + StdRandom.uniform(100000);
            int[] array = new int[N];
            int random = StdRandom.uniform(10000000);
            for (int i = 0; i < N; i++) {
                while (contained(array, random)) {
                    random = StdRandom.uniform(10000000);
                }
                array[i] = random;
            }
            double time = w1.elapsedTime();
            System.out.println(time);
            Stopwatch w2 = new Stopwatch();
            int min = LocalMinimunArray.searchMinimun(array);
            double time2= w2.elapsedTime();
            System.out.println("time2:  " + time2);

            check(array,min);
           /* System.out.println("N:  " + N);
            for(int i = 0; i < N; i++){

                System.out.println(i +":    " + array[i]);
            }*/
            //   System.out.println("minimo local:" +min);
            //  System.out.println("");
            //   System.out.println("");
        }



    }
    public static void check(int[] array, int min){
        Integer[] ar = new Integer[array.length];
        for(int i = 0; i<array.length; i++) ar[i] = array[i];
        int middle = java.util.Arrays.asList(ar).indexOf(min);
        int previous;
        int posterior;
        if( middle == 0  ) previous = 1000000000;
        else previous = array[middle-1];
        if (middle == array.length -1) posterior = 1000000000;
        else posterior = array[middle + 1];
        if( array[middle] < posterior && array[middle] < previous)
            System.out.println("ok");
        else
            System.out.println("fail");
    }

    public static boolean contained(int[] array, int n){
        for (int num : array){
            if(num == n) return true;
        }
        return false;
    }

}
