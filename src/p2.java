/**
 * Created by pablo on 21/06/2015.
 */
public class p2 {
    /**
     * Created by pablo on 20/06/2015.
     */

        private WeightedQuickUnionUF qF;
        private int[][] table;
        private int N;
        private int open;

        // create N-by-N grid, with all sites blocked
        public p2 (int N) {
            if (N <= 0) throw new java.lang.IllegalArgumentException();
            open = 0;
            this.N = N;
            qF = new WeightedQuickUnionUF(N * N + 2);
            table = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    table[i][j] = 0;
        }

        // open site (row i, column j) if it is not open already
        public void open(int i, int j) {

            if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
            if (j <= 0 || j > N) throw new IndexOutOfBoundsException("row index j out of bounds");

            if (!this.isOpen(i, j)) {
                table[i][j] = 1;
                open++;
                int index = (i - 1) * N + j;
                if (j == 1) {
                    qF.union(index, 0);
                } else {
                    if (this.isOpen(i, j - 1)) {
                        int index2 = (i - 1) * N + j - 1;
                        qF.union(index, index2);
                    }
                }
                if (j == N) {
                    qF.union(index, N * N + 1);
                } else {
                    if (this.isOpen(i, j + 1)) {
                        int index2 = (i - 1) * N + j + 1;
                        qF.union(index, index2);
                    }
                }
                if (i != 1) {
                    if (this.isOpen(i - 1, j)) {
                        int index2 = (i - 2) * N + j;
                        qF.union(index, index2);
                    }
                }
                if (i != N) {
                    if (this.isOpen(i + 1, j)) {
                        int index2 = i * N + j;
                        qF.union(index, index2);
                    }

                }
            }
        }

        // is site (row i, column j) open?
        public boolean isOpen(int i, int j) {

            if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
            if (j <= 0 || j > N) throw new IndexOutOfBoundsException("row index j out of bounds");
            boolean res = false;
            if (table[i][j] == 1) res = true;
            return res;
        }

        // is site (row i, column j) full?
        public boolean isFull(int i, int j) {

            if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
            if (j <= 0 || j > N) throw new IndexOutOfBoundsException("row index j out of bounds");
            int index = (i - 1) * N + j;
            return qF.connected(0, index);
        }

        // does the system percolate?
        public boolean percolates() {
            return qF.connected(0, N * N + 1);
        }

        public static void main(String args[]) {
            int N = 10;

            Percolation per = new Percolation(N);
            per.open(6, 1);
            System.out.println(per.isFull(6, 1));
            // for(int i = 1; i<=10; i++)        per.open(i,5);
   /*     while (!per.percolates()) {
            int i = 1 + StdRandom.uniform(N);
            int j = 1 + StdRandom.uniform(N);
            if (!per.isOpen(i, j)) {
                per.open(i, j);
            }

        }
        System.out.println(per.percolates());*/
        }


}
