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
        boolean noneleft = false;
        while (!noneleft) {
            //System.out.println("here");
            int none = 0;
            for (int v = 1; v <= 9; v++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (floodfill(i, j, v)) {
                            for (Pair p:toVisit) {
                                //System.out.print(p.i+" "+p.j+" ");
                                grid[p.i][p.j] = 0;
                            }                    
                        } else none++;
                        //System.out.println();
                        toVisit = new ArrayList<>();
                    }
                }
                visited = new boolean[n][10];
            }
            printBoard();
            for (int j = 0; j < 10; j++) {
                for (int i = n-1; i >= 0; i--) {
                    if (grid[i][j] > 0) {
                        for (int k = n-1; k >= 0; k--) {
                            if (grid[k][j] == 0) {
                                grid[k][j] = grid[i][j];
                                grid[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
            printBoard();
            System.out.println(none);
            //System.out.println("here");
            if (none == (n*10*9)) noneleft = true;
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(grid[i][j]);
                //out.print(grid[i][j]);
            }
            //out.print("\n");
            System.out.print("\n");
        }
        //out.close();

    }
    static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println();
    }
    static class Pair {
        int i;
        int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[] addi = {1, 0, -1, 0};
    static int[] addj = {0, 1, 0, -1};
    
    static boolean floodfill(int i, int j, int v) {
        int count = 0;
        boolean bool = false;
        if (grid[i][j] != 0) {System.out.println(i+" "+j); bool = true;}
        Stack<Pair> points = new Stack<>();
        points.push(new Pair(i, j));
        while (!points.isEmpty()) {
            Pair temp = points.pop();
            i = temp.i; 
            j = temp.j;
            if (i >= n || i < 0 || j >= 10 || j < 0 || grid[i][j] != v || visited[i][j]) continue;
            count++;
            
            visited[i][j] = true; 
            toVisit.add(new Pair(i, j));
            //System.out.println("here");
            for (int t = 0; t < 4; t++) {
                int i2 = i + addi[t];
                int j2 = j + addj[t];
                // if (!(i2 >= n || i2 < 0 || j2 < 0 || j2 >= n)) {
                //     if (grid[i2][j2] == v) count++; 
                // }
                points.push(new Pair(i2, j2));
            }
        }
        //System.out.println(count);
        if (bool) System.out.println(count);
        if (count >= k) return true;
        else return false;
    }
}