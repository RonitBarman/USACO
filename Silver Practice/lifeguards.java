import java.util.*;
import java.io.*;


public class lifeguards {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\Programming\\CP\\USACO\\Silver Practice\\6.in"));


        int n = Integer.parseInt(in.readLine());
        
        Pair[] guards = new Pair[n];
        long maxT = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st= new StringTokenizer(in.readLine());
            guards[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(guards);
        for (int i = 0; i < n; i++) {
            if (i == 0 || guards[i].x >= guards[i-1].y) maxT += guards[i].d;
            else if (guards[i-1].x <= guards[i].x && guards[i-1].y >= guards[i].y) {
                int te = i - 1;
                while (i < n && guards[i].y <= guards[te].y) {
                    i++;
                }
            }
            else maxT += guards[i].y - guards[i-1].y;
        }

        long max = maxT - guards[0].d + ((guards[0].y - guards[1].x > 0) ? guards[0].y - guards[1].x : 0);
        System.out.println(max+" asd");
        for (int i = 1; i < n; i++) {
            long b = (guards[i-1].y - guards[i].x > 0) ? guards[i-1].y - guards[i].x : 0;
            long e = 0;
            if (i == n - 1) e = 0;
            else e = (guards[i].y - guards[i+1].x > 0) ? guards[i].y - guards[i+1].x : 0;
            if (e >= guards[i].d || b >= guards[i].d) {max = Math.max(max, maxT); continue;}
            if (i < 100) System.out.println(max+ "max");
            max = Math.max(maxT - guards[i].d + b + e, max);
            
        }
        System.out.println(maxT);
        System.out.println(max);
        out.println(max);
        out.close();
    }

    static class Pair implements Comparable<Pair> {
        long x;
        long y;
        long d;
        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
            this.d = y-x;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x > o.x) return 1;
            if (this.x < o.x) return -1;
            else return 0;
        }
    }
}