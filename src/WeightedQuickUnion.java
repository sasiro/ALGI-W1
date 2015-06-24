/**
 * Created by pablo on 19/06/2015.
 */
public class WeightedQuickUnion extends QuickUnion {

    private int[] sz;

    public WeightedQuickUnion(int N) {
        super(N);
        sz = new int[N];
        for (int i = 0; i < N ; i++) sz[i] = 1;

        }


    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if(i == j) return;
        if(sz[i] < sz[j]) {id[i] = j; sz[j] += sz[i]; }
        else{id[j] = i; sz[i] += sz[j];}
    }
}
