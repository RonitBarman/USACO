import java.util.*;
import java.io.*;


public class lifeguards {

    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("lifeguards.in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

        int n = Integer.parseInt(in.readLine());
        
        Pair[] guards = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st= new StringTokenizer(in.readLine());
            guards[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(guards);
        int[] psums = new int[n+1];
        psums[0] = guards[0].x;
        for (int i = 1; i < n; i++) {
            if (i == 1) psums[i] = guards[i-1].d;
            else if (guards[i-1].x < guards[i-2].y) psums[i] = psums[i-1]+guards[i-1].y-guards[i-2].y;
            else psums[i] = psums[i-1]+guards[i-1].d;
        }
        int max = -1;
        for (int i = 1; i < n; i++) {
            
        }

    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int d;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.d = x-y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.x - o.x;
        }
    }
}