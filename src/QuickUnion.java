/**
 * Created by pablo on 19/06/2015.
 */
public class QuickUnion implements UnionALgs{

    protected int id[];

    public QuickUnion(int N){

        id = new int[N];
        for (int i = 0; i < N ; i++) id[i] = i;
    }

    protected int root(int p){
       while (id[p] != p) p = id[p];
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] =j;
    }
}
