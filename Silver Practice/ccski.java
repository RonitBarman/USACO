import java.io.*;
import java.util.*;

public class ccski {
    static int m, n;
    static int[][] elev;
    static int[][] way;
    static boolean[][] visited;
    static ArrayList<Pair> pairs;
    static int pts;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("ccski.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ccski.out")));
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\Programming\\CP\\USACO\\Silver Practice\\3.in"));
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        elev = new int[m][n];
        way = new int[m][n];
        visited = new boolean[m][n];
        int maxE = -1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                elev[i][j] = Integer.parseInt(st.nextToken());
                maxE = Math.max(elev[i][j], maxE);
            }
        }
        pts = 0;
        pairs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                way[i][j] = Integer.parseInt(st.nextToken());
                if (way[i][j] == 1) {
                    pairs.add(new Pair(i, j));
                    pts++;
                }
            }
        }

        int high = maxE + 1;
        int low = 0;
        while (low < high) {
            int mid = low + (high - low)/2;
            Pair temp = pairs.get(0);
            if (floodfill(temp.x, temp.y, mid)) high = mid;
            else low = mid + 1;
            visited = new boolean[m][n];
            //low++;
            //System.out.println(low+" "+high);
        }
        //System.out.println(isValid(21)+" "+isValid(23));
        System.out.println(low+" "+high);
        out.println(low);
        out.close();
    }

    static int[] di = {1, 0, -1, 0};
    static int[] dj = {0, -1, 0, 1};
    
    static boolean floodfill(int i, int j, int d) {
        int count = 0;
        ArrayDeque<Pair> points = new ArrayDeque<>();
        points.add(new Pair(i, j));
        while (!points.isEmpty()) {
            Pair p = points.pop();
            if (p.x < 0 || p.x >= m || p.y < 0 || p.y >= n || visited[p.x][p.y]) continue;
            visited[p.x][p.y] = true;
            if (way[p.x][p.y] == 1) count++;
            if (count == pts) break;
            for (int t = 0; t < 4; t++) {
                int ni = p.x + di[t];
                int nj = p.y + dj[t];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    if (Math.abs(elev[p.x][p.y] - elev[ni][nj]) <= d) points.add(new Pair(ni, nj));
                }
            }
        }
        return count == pts;
    }

    static class Pair {
        int x,y;
        Pair(int x, int y) { this.x = x; this.y = y; }
    }
}