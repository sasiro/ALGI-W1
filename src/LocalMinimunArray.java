import java.util.Arrays;

/**
 * Created by pablo on 22/06/2015.
 */
public  class LocalMinimunArray {


    private LocalMinimunArray(int n){
    }


    public static int searchMinimun(int[] array){
        int init = 0;
        int end = array.length-1;
        while(end - init > 1){
            int mid = init + (end-init)/2;
            int prev = array[mid-1];
            int post = array[mid+1];
            int middle = array[mid];
            if (middle < prev && middle < post)
                return middle;
            if(prev < post) end = mid-1;
            else init = mid+1;
        }
        if (init == end)
            return array[init];
        if (init == end-1)
            return min(array[init], array[end]);
        else return -1;
    }

    public static int min(int a, int b ){
        if (a < b) return a;
        else return b;
    }






}

