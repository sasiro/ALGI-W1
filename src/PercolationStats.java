/**
 * Created by pablo on 21/06/2015.
 */
public class PercolationStats {

    private double[] opens;
    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) throw new java.lang.IllegalArgumentException("");

        opens = new double[T];
        for (int count  = 0; count < T; count++) {
            int op = 0;
            Percolation per = new Percolation(N);
            while (!per.percolates()) {
                int i = 1 + StdRandom.uniform(N);
                int j = 1 + StdRandom.uniform(N);
                if (!per.isOpen(i, j)) {
                    per.open(i, j);
                    op++;
                }
            }
            opens[count] = (double) op/(N*N);
        }

    }

    // sample mean of percolation threshold
    public double mean() {
    return StdStats.mean(opens);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {

        return StdStats.stddev(opens);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
      return  mean() - (1.96*stddev()/Math.sqrt(opens.length));
        }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {

        return  mean() + (1.96*stddev()/Math.sqrt(opens.length));

    }

    // test client (described below)
    public static void main(String[] args)   {

        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        PercolationStats perStat =  new PercolationStats(N, T);
        System.out.println("mean                      = " + perStat.mean());
        System.out.println("sttdv                     = " + perStat.stddev());
        System.out.println("95% confidence interval = " + perStat.confidenceLo() +", " + perStat.confidenceHi());

    }
}