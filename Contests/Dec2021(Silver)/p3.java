import java.io.*;
import java.util.*;

public class p3 {
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("p3.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("p3.out")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int k = 0; k <= 2*m; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i] + a[j] <= k && k <= b[i] + b[j]) {
                        // ans = (i == j) ? ans + 1 : ans + 2;
                        ans++;
                    }
                }
            }
            System.out.println(ans);
            ans = 0;
        }
    }
}