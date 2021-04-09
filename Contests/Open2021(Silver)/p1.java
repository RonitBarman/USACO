import java.io.*;
import java.util.*;

public class p1 {

    static String[][] grid;
    static String[][] game = new String[3][3];
    static boolean[][] visited;
    static boolean[][] visited2;
    static int n;
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        grid = new String[n][n];
        visited = new boolean[n][n];
        visited2 = new boolean[n][n];
        Pair bessie = new Pair(0, 0);

        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            for (int j = 0; j < 3*n; j+=3) {
                if (line.charAt(j) == '#') grid[i][j/3] = "###";
                else grid[i][j/3] = (line.charAt(j)+"")+(line.charAt(j+1)+"")+(line.charAt(j+2)+"");
                if (grid[i][j/3].equals("BBB")) bessie = new Pair(i, j/3);
            }
            
        }
        
        //System.out.println(bessie.i+" "+bessie.j);
        // System.out.println(isDone(new String[][]{
        //     {"M", "O", "Z"},
        //     {"", "", ""},
        //     {"", "", ""}}));
        for (int i = 0; i < 8; i++) {
            floodfill(bessie.i, bessie.j, i);
            game = new String[3][3];
            visited = new boolean[n][n];
            visited2 = new boolean[n][n];
            //System.out.println("DONE");
        }
        System.out.println(count);

	}

    static int[][] addi = {
        {1, 0, -1, 0},
        {1, -1, 0, 0},
        {-1, 0, 1, 0},
        {1, 0, 0, -1},

        // {0, 0, -1, 1},
        // {0, 0, 1, -1},
        // {0, 1, 0, -1},
        // {0, 0, -1, 1},
        // {0, -1, 0, 1},
        // {0, -1, 1, 0},
        // {0, 1, -1, 0},

        {-1, 0, 1, 0},
        {-1, 1, 0, 0},
        {-1, 0, 1, 0},
        {-1, 0, 0, 1},

    };
    static int[][] addj ={
        {0, 1, 0, -1},
        {0, 0, -1, 1},
        {0, -1, 0, 1},
        {0, -1, 1, 0},

        // {-1, 1, 0, 0},
        // {1, -1, 0, 0},
        // {1, 0, -1, 0},
        // {1, -1, 0, 0},
        // {-1, 0, 1, 0},
        // {1, 0, 0, -1},
        // {-1, 0, 0, 1},

        {0, -1, 0, 1},
        {0, 0, 1, -1},
        {0, 1, 0, -1},
        {0, 1, -1, 0}
    };
    static int count = 0;
    static void floodfill(int i, int j, int c) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(i, j));
        
        while (!stack.isEmpty()) {
            //System.out.println("HERE");
            Pair p = stack.pop();
            i = p.i; j = p.j;
            //System.out.println(Arrays.deepToString(game));

            if (i >= n || i < 0 || j >= n || j < 0 || grid[i][j].equals("###")) continue;

            visited2[i][j] = true;
            String[] temp = grid[i][j].split("");
            //System.out.println(i+" "+j);
            if (temp[0].equals("M") || temp[0].equals("O")) {
                //System.out.println("HERE");
                visited2[i][j] = true;
                Pair co = new Pair(Integer.parseInt(temp[1])-1, Integer.parseInt(temp[2])-1);
                if (game[co.i][co.j] == null) game[co.i][co.j] = grid[i][j].charAt(0)+"";
            }
            
            if (isDone(game)) {count++; break;}

            for (int t = 0; t < 4; t++) {
                int i2 = i + addi[c][t];
                int j2 = j + addj[c][t];
                
                if (!grid[i2][j2].equals("###") && visited2[i2][j2]) {
                    stack.push(new Pair(i2, j2));
                    //System.out.println(i2+" "+j2+" n");
                }
            }
            int cn = 0;
            for (int t = 0; t < 4; t++) {
                int i2 = i + addi[c][t];
                int j2 = j + addj[c][t];
                if (!grid[i2][j2].equals("###") && !visited2[i2][j2]) {
                    stack.push(new Pair(i2, j2));
                    cn++;
                    //System.out.println(i2+" "+j2+" n");
                }
            }
            if (cn == 0) {
                while (!stack.empty()) {
                    if (visited2[stack.peek().i][stack.peek().j]) stack.pop();
                    else break;
                }
            }
            //System.out.println(Arrays.deepToString(game));
            //System.out.println(stack.size());
            //System.out.println("HERE");
        }
    }

    static class Pair {
        int i;
        int j;
        Pair(int i, int j) {this. i = i; this.j = j;}
    }

    static boolean isDone(String[][] game) {
        String tem = "";
        for (int i = 0; i < 3; i++) {
            tem = game[i][0]+game[i][1]+game[i][2];
            if (tem.equals("MOO") || tem.equals("OOM")) return true;
        }
        for (int i = 0; i < 3; i++) {
            tem = game[0][i]+game[1][i]+game[2][i];
            if (tem.equals("MOO") || tem.equals("OOM")) return true;
        }
        tem = game[0][0]+game[1][1]+game[2][2];
        if (tem.equals("MOO") || tem.equals("OOM")) return true;
        tem = game[2][0]+game[1][1]+game[0][2];
        if (tem.equals("MOO") || tem.equals("OOM")) return true;
        int t = 0;
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) if (game[i][j] != null) t++;
        if (t == 9) return true;
        return false;
    }

    // static HashSet<int[]> adi = new HashSet<>();
    // static void permute(int[] cows, int s, int[] limits) {
    //     if (s == 1) {
    //         int[] temp = new int[cows.length];
    //         for (int i = 0; i < cows.length; i++) temp[i] = cows[i];
    //         adi.add(temp);
    //     } else {
    //         permute(cows, s-1, limits);
    //         for (int i = 0; i < s-1; i++) {
    //             if (s % 2 == 0) {
    //                 swap(cows, i, s-1);
    //             } else {
    //                 swap(cows, 0, s-1); 
    //             }
    //             permute(cows, s-1, limits);
    //         }
    //     }
    // }

    // static void swap(int[] arr, int e1, int e2) {
    //     int obj1 = arr[e1];
    //     int obj2 = arr[e2];
    //     arr[e1] = obj2;
    //     arr[e2] = obj1;
    // }
}