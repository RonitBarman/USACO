import java.util.*;

import java.io.*;

public class cowtip {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cowtip.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][n];
        int cn = 0;
        for (int i = 0; i < n; i++) {
            for (String str:in.readLine().split("")) {
                grid[i][cn] = Integer.parseInt(str);
                cn++;
            }
            cn=0;
        }
        boolean[] status = new boolean[n];
        int count = 0;
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    count++;
                    for (int r = 0; r <= i; r++) {
                        for (int c = 0; c <= j; c++) {
                            if (grid[r][c] == 0) grid[r][c] = 1;
                            else grid[r][c] = 0;
                        }
                    }
                }
            }
        }


        System.out.println(count);
        out.println(count);
        out.close();
    }
}
