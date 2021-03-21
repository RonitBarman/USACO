import java.io.*;
import java.util.*;

public class p3 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] grid = new int[n][n];
        int count = 0;
        HashSet<Pair> cells = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 100) {
                    count++;
                    cells.add(new Pair(i, j));
                }
            }
        }
        for (Pair p : cells) {
            for (int i = p.x; i < n; i++) {
                if (grid[i][p.y])
            }
        }

    }
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
