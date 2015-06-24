/**
 * Created by pablo on 21/06/2015.
 */
public class Successor {

    WeightedQuickUnionUF wQ;
    private int[] largest;
    private byte[] removed;
    private int N;

    public  Successor(int n){
        this.N = n;
        largest = new int[N];
        removed = new byte[N];
        wQ = new WeightedQuickUnionUF(N);
        for (int i = 0; i < N; i++){
            largest[i] = i;
            removed[i] = 0;
        }

    }

    public void remove(int n){
        if ( removed[n] == 1) return;
        if (n == N-1) {
            removed[n] = 1;
            largest[n] = -1;
            if (removed[n-1]==1){
                largest[wQ.find(n-1)] = -1;
            }
            return;
        }
        int rootN =  wQ.find(n);
        int rootS = wQ.find(n+1);
        wQ.union(n, n+1);
        if(largest[rootS] == -1){
            largest[rootN] = -1;
        } else{
            if (wQ.find(n+1) != rootS){
            largest[rootN] = largest[rootS];
            }
        }
        removed[n] = 1;
    }

    public int getSuccessor(int n){

        if (n == N-1){
            if(removed[n] == 0) return n;
            else return -1;
        }
       return  largest[wQ.find(n)];
    }

    public static void main (String args[]) {
        Stopwatch time ;
        int T = 3;
        int N = 50000000;
        for (int count = 0; count < T; count++) {
            time = new Stopwatch();
            Successor s = new Successor(N);
            for (int i = 0; i > N; i++) {
                int num = 1 + StdRandom.uniform(N);
                int num1= 1 + StdRandom.uniform(N);
                int num2 = 1 + StdRandom.uniform(N);
                int num3 = 1 + StdRandom.uniform(N);
                int num4 = 1 + StdRandom.uniform(N);
                int num5 = 1 + StdRandom.uniform(N);
                int num6 = 1 + StdRandom.uniform(N);
                int num7 = 1 + StdRandom.uniform(N);
                int num8= 1 + StdRandom.uniform(N);
                int num9= 1 + StdRandom.uniform(N);

                s.remove(num);
                s.getSuccessor(num1);
                s.remove(num2);
                s.getSuccessor(num3);
                s.remove(num4);
                s.getSuccessor(num5);
                s.remove(num6);
                s.getSuccessor(num7);
                s.remove(num8);
                s.getSuccessor(num9);

            }
            System.out.println("numero de elementos :" + N + "   tiempo de ejec: " + time.elapsedTime());
            N = N * 2;
        }
    }
}
