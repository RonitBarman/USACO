import java.io.*;
import java.util.*;

public class p2 {
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("p2.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("p2.out")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] h = new int[n];
        int[] maxs = new int[n];
        int maxx = -1;
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
            maxs[i] = Math.max(maxx, h[i]);
        }
        long ans = 0L;
        long max = -1L;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (h[j] > max) {
                    if (max > h[i]) break;
                    ans += j - i + 1;
                    max = h[j];
                }
                max = Math.max(max, h[j]);
            }
            max = -1L;
        }
        System.out.println(ans);
    }
}