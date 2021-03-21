import java.io.*;
import java.util.*;
// http://www.usaco.org/index.php?page=viewproblem2&cpid=895

public class perimeter {

    static ArrayList<Integer>[] adj;
    static boolean[][] visited;
    static char[][] grid;
    static int n;
   
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("perimeter.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        n = Integer.parseInt(in.readLine());
        grid = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String temp = in.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = temp.charAt(j);
            }
        }
        int maxA = -1;
        int peri = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    Pair temp = floodfill(i, j);
                    int na = temp.x;
                    int np = temp.y;
                    if (na > maxA) peri = np;
                    else if (na == maxA) peri = Math.min(peri, np);
                    maxA = Math.max(maxA, na);
                }
            }
        }
        System.out.println(maxA+" "+peri);
        out.println(maxA+" "+peri);
        out.close();

    }

    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] addi = {1, 0, -1, 0};
    static int[] addj = {0, 1, 0, -1};

    static Pair floodfill(int i, int j) {
        Stack<Pair> points = new Stack<>();
        int peri = 0; int area = 0;
        points.push(new Pair(i, j));
        while (!points.isEmpty()) {
            Pair temp = points.pop();
            i = temp.x; 
            j = temp.y;
            if (i >= n || i < 0 || j >= n || j < 0 || grid[i][j]=='.' || visited[i][j]) continue;
            visited[i][j] = true;   
            area++;

            for (int t = 0; t < 4; t++) {
                int i2 = i + addi[t];
                int j2 = j + addj[t];
                if (i2 >= n || i2 < 0 || j2 < 0 || j2 >= n) peri++;
                else if (grid[i2][j2] == '.') peri++;
                points.push(new Pair(i2, j2));
            }
        }
        return new Pair(area, peri);
    }
}
