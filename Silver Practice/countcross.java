import java.io.*;
import java.util.*;
// http://www.usaco.org/index.php?page=viewproblem2&cpid=716

public class countcross {

    static ArrayList<Integer>[] adj;
    static boolean[][] visited;
    static char[][] grid;
    static int n;
    static HashSet<Road> roads;

    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Road {
        Pair p;
        Pair q;
        public Road(Pair p, Pair q) {
            this.p = p;
            this.q = q;
        }
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("countcross.in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(in.readLine());
            roads.add(new Road(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())), 
                      new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))));            
        }
        Pair[] cows = new Pair[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(in.readLine());
            cows[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    for (int d = 0; d < 4; d++) {
                        if (roads.contains(o))
                    }
                }
            }
        }
    }
    

    static int[] addi = {1, 0, -1, 0};
    static int[] addj = {0, 1, 0, -1};

    static boolean floodfill(int i, int j, int x, int y) {
        int rep = 0;
        int jo = j;
        int io = i;
        Stack<Pair> points = new Stack<>();
        points.push(new Pair(i, j));
        while (!points.isEmpty()) {
            Pair temp = points.pop();
            i = temp.x; 
            j = temp.y;
            if (i >= n || i < 0 || j >= n || j < 0 || visited[i][j]) continue;
            if ()
            visited[i][j] = true;   
            
            for (int t = 0; t < 4; t++) {
                int i2 = i + addi[t];
                int j2 = j + addj[t];
                Road ro = new Road(new Pair(i, j), new Pair(i2, j2));
                if (roads.contains(ro)) rep++;
                ro = new Road(new Pair(i2, j2), new Pair(i, j));
                if (roads.contains(ro)) rep++;
                points.push(new Pair(i2, j2));
            }
        }
        return rep == 4;
    }
}