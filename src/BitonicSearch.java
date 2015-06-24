/**
 * Created by pablo on 23/06/2015.
 */
public class BitonicSearch {

    public static int search(int[] arrayBitonic, int value){
        int res;
        int init = 0;
        int end = arrayBitonic.length - 1 ;
        int midPos = (end - init)/2;
        if ( arrayBitonic[midPos] == value){
            return midPos;
        }

            while (value > arrayBitonic[midPos] && init < end){

                if ( arrayBitonic[midPos-1] < arrayBitonic[midPos] ){
                      init = midPos+1;
                      midPos = init + (end-init)/2;
                  }
                else{
                        end = midPos-1;
                        midPos = init + (end-init)/2;
                    }

            }
        if( value == arrayBitonic[midPos]) return midPos;
        if ( arrayBitonic[midPos-1] < arrayBitonic[midPos] ){
            res = ascendingSearch(arrayBitonic, init, midPos-1, value);
            if (res != -1) return res;
            else {
                res = descendingSearch(arrayBitonic, midPos+1, end, value );
                    }
                }
        else {
            res = descendingSearch(arrayBitonic, init, midPos-1, value);
            if (res != -1) return res;
            else {
                res = ascendingSearch(arrayBitonic, midPos+1, end, value );
            }
        }

        return res;
    }

    public static int ascendingSearch(int[] array, int init, int end, int value){
        int lo = init;
        int high = end;
        while (high >= lo){
            int mid = lo + (high-lo)/2;
            if(value == array[mid]) return mid;
            else if(value>array[mid]) lo = mid+1;
            else high = mid-1;
        }
        return -1;
    }

    public static int descendingSearch(int[] array, int init, int end, int value) {
        int lo = init;
        int high = end;
        while (high >= lo) {
            int mid = lo + (high - lo) / 2;
            if (value == array[mid]) return mid;
            else if (value < array[mid]) lo = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String args[]){
        double timerInit;
        double timerEnd;
        double time;
        int rep = 10000;
        double tTime = 0;
        int N = 100000000;
        int j = 0;
        int[] array = new int[N];
        int rand = 1 + StdRandom.uniform(N);
        for (int i = 0; i <= rand; i++ ) array[i] = i*2;
        for(int i = rand; i < N; i++,j+=2) array[i] = (i - j);
        // for (int n : array) System.out.println(n);
        int x = 1 + StdRandom.uniform(999999999);
        for (int i = 0; i<rep; i++){
             timerInit = System.nanoTime();
             int pos = search(array,x);
             timerEnd = System.nanoTime();
             time = timerEnd - timerInit;
             tTime += time;
        }
        tTime = tTime / rep;
        System.out.println("Array size: " + N + "   time: " +tTime);
       /* System.out.println("numero: " + x);
        System.out.println("posiscion en array:                " + pos);
        System.out.println( "Valor inicial buscado:             " + x);
        if(pos > -1)
        System.out.println("valor del array en pos devuelta:   " + array[pos]);*/

    }
}
