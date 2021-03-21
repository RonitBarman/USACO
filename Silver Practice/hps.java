import java.io.*;
import java.util.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=691

public class hps {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("hps.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        int n = Integer.parseInt(in.readLine());

        int[][] wins = new int[3][n+1];
        int hc = 0;
        int pc = 0;
        int sc = 0;
        for (int i = 1; i < n+1; i++) {
            String temp = in.readLine();
            if (temp.equals("H")) pc++;
            else if (temp.equals("P")) sc++;
            else if (temp.equals("S")) hc++;
            wins[0][i] = hc;
            wins[1][i] = pc;
            wins[2][i] = sc;
        }
        // for (int i = 0; i < n+1; i++) System.out.print(wins[0][i]+" ");
        // System.out.println();
        // for (int i = 0; i < n+1; i++) System.out.print(wins[1][i]+" ");
        // System.out.println();
        // for (int i = 0; i < n+1; i++) System.out.print(wins[2][i]+" ");
        // System.out.println();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    for (int k = 1; k < n; k++) {
                        max = Math.max(wins[i][k+1]-wins[i][0] + wins[j][n]-wins[j][k], max);
                        max = Math.max(wins[j][k+1]-wins[j][0] + wins[i][n]-wins[i][k], max);
                    }
                }
            }
        }

        System.out.println(max+" max");
        out.println(max);
        out.close();
    }
}