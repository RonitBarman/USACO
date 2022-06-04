import java.io.*;
import java.util.*;

public class p1 {
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("p1.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("p1.out")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Pair[] grass = new Pair[k];
        Pair[] grassr = new Pair[k];
        int[] f = new int[m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(in.readLine());
            grass[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            grassr[i] = new Pair(grass[i].x, grass[i].y);
        }
        Arrays.sort(grass);
        Arrays.sort(grassr, new rev());
        for (int i = 0; i < m; i++) f[i] = Integer.parseInt(in.readLine());
        Arrays.sort(f);
        //System.out.println(grassr[0].x + " ggg");
        int taste = 0;
        for (int i = 0; i < k; i++) {
            int l = closest(grass, f, i, m);
            //System.out.println(f[l] + " f");
            if (n == 0) break;
            if (grass[i].y == -1) continue;
            if (f[l] != grass[i].x) {

                int r = closest(grass, grassr, i, m);
                int d = closest(grass, f, r, m);
                if (Math.abs(f[d] - grass[r].x) > Math.abs(((double) grass[i].x - (double) grass[r].x)/2)) {
                    taste += grass[r].y;
                    grass[r].y = -1;
                }
                //System.out.println(grass[r].y + " ry");
                taste += grass[i].y;
                //System.out.println(grass[i].y + " iy");
                n--;
                //System.out.println(Math.abs(((double) grass[i].x - (double) grass[r].x)/2));
                //System.out.println(taste);
            } else continue;
        }
        System.out.println(taste);
    }

    static class Pair implements Comparable<Pair> {
        int x,y;
        Pair(int x, int y) { this.x = x; this.y = y; }
        
        @Override
        public int compareTo(Pair p) {
            if (p.y - this.y != 0) return p.y - this.y;
            else return p.x - this.x;
        }
    }

    static int closest(Pair[] grass, int[] f, int i, int m) {
        int l = 0;
        int r = m - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (grass[i].x - f[mid] <= 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    static int closest(Pair[] grass, Pair[] grassr, int i, int m) {
        int d = 0;
        int l = 0;
        int r = grassr.length - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (grass[i].x - grassr[mid].x <= 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        //ystem.out.println(grassr[l].x + " " + grass[l].x);
        d = l;
        

        // for (int j = 0; j < grass.length; j++) {
        //     if (grass[i].x == grassr[j].x) d = j;
        // }
        
        for (int j = 0; j < grassr.length; j++) {
            
            if (grass[j].x == grassr[d - 1].x) return j;
        }
        return 0;
    }

    static class rev implements Comparator<Pair> {

        @Override
        public int compare(Pair a, Pair b) {
            return a.x - b.x;
        }
    }
}