import java.io.*;
import java.util.*;

public class paintbarn2 {
    
	public static void main(String[] args) throws IOException {
    	//BufferedReader in = new BufferedReader(new FileReader("paintbarn.in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] grid = new int[1001][1001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int a, b, c, d;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            grid[a][b]++;
            grid[a][d]--;
            grid[c][b]--;
            grid[c][d]++;
        }
        int coats = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                coats += grid[i][j];
                coats -= grid[i-1][j];
                coats -= grid[i][j-1];
                coats += grid[i-1][j-1];
            }
        }
        System.out.println(coats);


	}
}

