/**
 * Created by pablo on 20/06/2015.
 */
public class WeigthedQuickUnionPathCompresion extends  WeightedQuickUnion {


    public WeigthedQuickUnionPathCompresion(int N) {
        super(N);
    }

    @Override
    protected  int root(int i){

        while (i != id[i]){

            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}
