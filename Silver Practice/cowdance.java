import java.io.*;
import java.util.*;

public class cowdance {
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("cowdance.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n, t = 0;
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(in.readLine());
        }
        System.out.println("__");
        System.out.println(isValid(3, d, t));
        System.out.println(isValid(4, d, t));
        System.out.println(isValid(5, d, t));
    }

    static boolean isValid(int k, int[] d, int t) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < d.length; i++) pq.add(d[i]);
        while (!pq.isEmpty()) {
            PriorityQueue<Integer> tpq = new PriorityQueue<>();
            int max = -1;
            if (tpq.size() < k) {
                for (int i = 0; i < k - tpq.size(); i++) {
                    if (pq.peek() == null) break;
                    if (tpq.peek() == null) { tpq.add(pq.poll()); continue; }
                    if (pq.peek() >= tpq.peek()) tpq.add(pq.poll());
                }
            }
            int min = tpq.poll();
            int temp = 0;
            for (int i = 0; i < k; i++) {
                if (tpq.peek() == null) break;
                temp = tpq.poll();
                if (temp - min <= 0) continue;
                tpq.add(temp - min);
            }
            min = (tpq.peek() == null) ? temp : tpq.poll();
            t -= min;
            System.out.println(t);
            // for (int i = 0; i < k; i++) {
            //     if (pq.peek() == null) break;
            //     int temp = pq.poll();
            //     tpq.add(temp);
            //     max = Math.max(temp, max);
            // }
            // t -= max; 
        }
        return t >= 0;
    }
}