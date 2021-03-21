import java.io.*;
import java.util.*;

public class proximity {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("proximity.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("proximity.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] counts = new int[1_000_000];
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) ids[i] = Integer.parseInt(in.readLine());
        int maxId = -1;
        for (int i = 0; i < k; i++) {
            counts[ids[i]]++;
            if (counts[ids[i]] >= 2) maxId = Math.max(maxId, ids[i]);
        }
        for (int i = 1; i < n-k; i++) {
            counts[ids[i-1]]--;
            counts[ids[i+k]]++;
            if (counts[ids[i]] >= 2) maxId = Math.max(maxId, ids[i]);
        }
        System.out.println(maxId+" ANS");
        out.println(maxId);
        out.close();
    }
}