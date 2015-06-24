/**
 * Created by pablo on 19/06/2015.
 */
public class QuickFind implements UnionALgs{

    private int[] id;

    public QuickFind(int N){

        id = new int[N];
        for (int i = 0; i < N ; i++) id[i] = i;
    }

    @Override
    public boolean connected(int p, int q) {

        return id[p] == id[q];
    }

    @Override
    public void union(int p, int q) {

        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length ; i++){
            if (id[i] == pid) id[i] = qid;
        }
    }

}
