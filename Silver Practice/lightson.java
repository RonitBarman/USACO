import java.io.*;
import java.util.*;
// http://www.usaco.org/index.php?page=viewproblem2&cpid=570
public class lightson {

    static ArrayList<Integer>[] adj;
    static boolean[][] visited;
    static int n;
    static boolean[][] on;
    static ArrayList<Pair>[][] lights;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("lightson.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lights = new ArrayList[n][n];
        visited = new boolean[n][n];
        on = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lights[i][j] = new ArrayList<Pair>();
            }
        }
        for (int i = 0; i < m; i++) {
            String[] temp = in.readLine().split(" ");   
            int a = Integer.parseInt(temp[0])-1;
            int b = Integer.parseInt(temp[1])-1;
            Pair t2 = new Pair(Integer.parseInt(temp[2])-1, Integer.parseInt(temp[3])-1);
            lights[a][b].add(t2);
            
        }
        on[0][0] = true;
        floodfill(0, 0);
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (on[i][j]) c++;
            }
        }
        System.out.println(c);
        out.println(c);
        out.close();
    }
    
    static class Pair {
        int x,y;
        Pair(int x, int y) { this.x = x; this.y = y; }
    }

    static int[] addi = {1, 0, -1, 0};
    static int[] addj = {0, 1, 0, -1};

    static void floodfill(int i, int j) {
        if (!isV(i, j) || visited[i][j]) return;
        visited[i][j] = true;
        for (Pair p : lights[i][j]) {
            if (!on[p.x][p.y]) {
                on[p.x][p.y] = true;
                if (visitedNeighbors(p.x, p.y)) {
                    floodfill(p.x, p.y);
                }
            }
        }
        for (int t = 0; t < 4; t++) {
            int i2 = i + addi[t];
            int j2 = j + addj[t];
            if (i2 >= 0 && j2 >= 0 && i2 < visited.length && j2 < visited.length && on[i2][j2]) floodfill(i2, j2);
        }
    }
    static boolean isV(int i, int j) {
        if (i >= 0 && j >= 0 && i < visited.length && j < visited.length) return true;
        return false;
    }
    static boolean visitedNeighbors(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int i2 = x + addi[i];
            int j2 = y + addj[i];
            if (i2 >= 0 && j2 >= 0 && i2 < visited.length && j2 < visited.length && visited[i2][j2] && on[i2][j2]) return true;
        }
        return false;
    }
    
    
}