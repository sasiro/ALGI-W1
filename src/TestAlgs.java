/**
 * Created by pablo on 19/06/2015.

public class TestAlgs {

    public static void main(String args[]){
        int N = 1000000;
        long timeInit  = System.currentTimeMillis();
        QuickFind qf = new QuickFind(N);
        for(int i = 0; i < N-1; i++){
            int random = (int) (1000.0 * Math.random());
            qf.union(i, random/2);
            qf.connected(i, random);
        }
        long timeEnd = System.currentTimeMillis();
        long totalTime = timeEnd - timeInit;
        double secs = 1000.0;
        System.out.println( totalTime/secs + " segundos");


    }
}
 */