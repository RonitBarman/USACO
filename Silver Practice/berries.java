import java.io.*;
import java.util.*;

public class berries {
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader("berries.in"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] trees = new int[n];   
        int max = -1;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }
        // Arrays.sort(trees);
        // ArrayList<Integer> buckets = new ArrayList<>();
        // int t = k;
        
        // for (int i = n - 1; i >= 0; i--) {
        //     if (buckets.isEmpty()) {
        //         buckets.add(trees[i] / 2); buckets.add(trees[i] / 2);
        //         t -= 2;
        //     } else if (trees[i] / 2 > buckets.get(buckets.size() / 2)) {
        //         buckets.add(trees[i] / 2); buckets.add(trees[i] / 2);
        //         t -= 2;
        //     } else {buckets.add(trees[i]); t--;}
        //     Collections.sort(buckets);
        //     if (t <= 0) break;
        // }
        // int ans = 0;
        // for (int i = buckets.size() / 2 - 1; i >= 0; i--) ans += buckets.get(i);
        // System.out.println(ans);
        // out.println(ans);
        // out.close();

    }
}