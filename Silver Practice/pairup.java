import java.io.*;
import java.util.*;

public class pairup {
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader("pairup.in"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Pair[] cows = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            cows[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(cows);
        //System.out.println(cows[1].y + "y");
        int left = 0;
        int right = n - 1;
        int max = -1;
        while (left <= right) {
            if (left >= n || right < 0) break;
            max = Math.max(max, cows[left].y + cows[right].y);
            cows[left].x --;
            cows[right].x --;
            if (cows[left].x == 0) left++;
            if (cows[right].x == 0) right--;
            //System.out.println(max);
        }
        
        System.out.println(max);
        // out.println(max);
        // out.close();
    }

    static class Pair implements Comparable {
        int x,y;
        Pair(int x, int y) { this.x = x; this.y = y; }

        @Override
        public int compareTo(Object o) {
            return this.y - ((Pair) o).y;
        }
    }
}