import java.io.*;
import java.util.*;

public class socdist2 {

    static int n;
    static int m;
    static Pair[] intervals = new Pair[m];
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader("socdist.in"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        intervals = new Pair[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            intervals[i] = new Pair(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
        }
        Arrays.sort(intervals);
        //for (Pair p : intervals) System.out.println(p.x+" "+p.y);

        System.out.println(isValid(2));
        System.out.println(isValid(3));
        long high = (long) Math.pow(10, 18);
        System.out.println(isValid(high)+" an");
        long low = 0;
        // while (low < high) {
        //     //low--;
        //     long mid = low + (high - low + 1)/2;
        //     if (isValid(mid)) low = mid;
        //     else high = mid - 1;
        //     // System.out.println(low+" low");
        //     // System.out.println(high+" high");
        // }
        System.out.println(low+" L");
        System.out.println(Long.MAX_VALUE);
        // out.println(low);
        // out.close();
    }

    static boolean isValid(long d) {
        int c = n;
        Pair prev = new Pair(-d, -d);
        for (Pair pair : intervals) {
            long t = (pair.y - pair.x) / d + 1;
            if (pair.x - prev.y >= d) c -= t;
            else {
                t = (pair.y - (prev.y + d)) / d + 1;
                c -= t;
            }
            prev = new Pair(pair.x, pair.x + (t - 1)*d);
            if (c <= 0) break;
        }
        return c <= 0;
    }

    static class Pair implements Comparable<Pair> {
        long x,y;
        Pair(long x, long y) { this.x = x; this.y = y; }
        @Override
        public int compareTo(socdist2.Pair o) {
            long l = this.x - o.x;
            if (l > 0) return 1;
            if (l < 0) return -1;
            return 0;
        }
    }
}