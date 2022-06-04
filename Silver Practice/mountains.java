import java.io.*;
import java.util.*;

public class mountains {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Pair[] peaks = new Pair[n];
        boolean[] done = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            peaks[i] = new Pair(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
        }
        Arrays.sort(peaks);
        int vis = n;
        for (int i = n - 1; i >= 0; i--) {
            if (done[i]) continue;
            for (int j = i - 1; j >= 0; j--) {
                if (done[j]) continue;
                int d = peaks[i].y - peaks[j].y;
                if (peaks[j].x >= peaks[i].x - d && peaks[j].x <= peaks[i].x + d) { vis--; done[j] = true; }
            }
        }

        System.out.println(vis);
        out.println(vis);
        out.close();

    }

    static class Pair implements Comparable<Pair> {
        int x,y;
        Pair(int x, int y) { this.x = x; this.y = y; }
        @Override
        public int compareTo(mountains.Pair o) {
            return this.y - o.y;
        }
    }
}