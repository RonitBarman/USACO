import java.io.*;
import java.util.*;

public class socdist {
    static Pair[] intervals;
    static int n;
    static int m;
	public static void main(String[] args) throws IOException {
    	BufferedReader in = new BufferedReader(new FileReader("socdist.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        intervals = new Pair[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            intervals[i] = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
        in.close();
        Arrays.sort(intervals);
        for (int i = 0; i < m; i++) System.out.print(intervals[i].b + " " + intervals[i].e+"   ");
        System.out.println();
        long lo = 1;
        long hi = (intervals[m-1].e-intervals[0].b)/(n - 1);
        while (lo < hi) {
			long mid = ((hi+lo+1)/2);
			if (isValid(mid)) lo = mid;
			else hi = mid-1;
		}
        System.out.println(lo);
        System.out.println(count+"c");
        out.println(lo);

        out.close();
	}

    static class Pair implements Comparable<Pair> {
        long b, e, q;
        Pair(long b, long e) {this.b = b; this.e = e; this.q = e-b;}

        @Override
        public int compareTo(socdist.Pair o) {
            if (this.b > o.e) return 1;
            if (this.b < o.e) return -1;
            return 0;
        }
    }
    static int count = 0;
    static boolean isValid(long d) {
        System.out.println(n);
        int r = n;
        long prev = Long.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            while (Math.max(prev + d, intervals[i].b) <= intervals[i].e) {
                prev = Math.max(prev + d, intervals[i].b);
                r--;
                if (r <= 0) break;
            }
            
            // if (i > 0) System.out.println(intervals[i].b - intervals[i-1].e+" i " + d);
            // if (i == 0 || intervals[i].b - intervals[i-1].e >= d) {
            //     val = (intervals[i].q/d) + 1;
            //     r -= (val >= 0) ? val : 0;
            //     //System.out.println(intervals[i].b - intervals[i-1].e+" i ");
            // }
            // else {
            //     val = ((intervals[i].e - (intervals[i-1].e + d))/d) + 1;
            //     r -= (val >= 0) ? val : 0;
            // }
            // System.out.println(r+" r");
            // //System.out.println(r+" r "+d);
            // //if (r == 0) break;
            if (r <= 0) break;
        }
        //count++;
        return r <= 0;
    }
}
/**
5 3
0 2
4 7
9 9
 */