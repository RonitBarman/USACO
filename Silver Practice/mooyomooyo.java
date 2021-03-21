import java.io.*;
import java.util.*;
// http://www.usaco.org/index.php?page=viewproblem2&cpid=860

public class mooyomooyo {

    static ArrayList<Integer>[] adj;
    static boolean[][] visited;
    static int[][] grid;
    static int n;
    static int k;
    static ArrayList<Pair> toVisit = new ArrayList<>();
   
    
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("mooyomooyo.in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][10];
        visited = new boolean[n][10];

        for (int i = 0; i < n; i++) {
            String[] temp = in.readLine().split("");
            for (int j = 0; j < 10; j++) grid[i][j] = Integer.parseInt(temp[j]);
        }
        for (int v = 1; v <= 9; v++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    if (floodfill(i, j, v)) {
                        for (Pair p:toVisit) {
                            grid[p.i][p.j] = 0;
                        }                    
                    }
                    visited = new boolean[n][10];
                    toVisit = new ArrayList<>();
                }
            }
            // for (int j = 0; j < 10; j++) {
            //     for (int i = 0; i < n; i++) {
            //         if (grid[i][j] > 0) {
            //             for (int k = n-1; k >= 0; k--) {
            //                 if (grid[k][j] == 0) {
            //                     //grid[k][j] = grid[i][j];
            //                     //grid[i][j] = 0;
            //                     break;
            //                 }
            //             }
            //         }
            //     }
            // }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
        }

    }

    static class Pair {
        int i;
        int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static void replace() {
        
    }

    static int[] addi = {1, 0, -1, 0};
    static int[] addj = {0, 1, 0, -1};
    
    static boolean floodfill(int i, int j, int v) {
        int count = 0;
        Stack<Pair> points = new Stack<>();
        points.push(new Pair(i, j));
        while (!points.isEmpty()) {
            Pair temp = points.pop();
            i = temp.i; 
            j = temp.j;
            if (i >= n || i < 0 || j >= n || j < 0 || grid[i][j] != v || visited[i][j]) continue;
            if (grid[i][j] == v) count++;
            visited[i][j] = true; 
            toVisit.add(new Pair(i, j));
                
            for (int t = 0; t < 4; t++) {
                int i2 = i + addi[t];
                int j2 = j + addj[t];
                if (!(i2 >= n || i2 < 0 || j2 < 0 || j2 >= n)) {
                    if (grid[i2][j2] == v) count++; 
                }
                points.push(new Pair(i2, j2));
            }
        }
        if (count >= k) return true;
        else return false;
    }
}