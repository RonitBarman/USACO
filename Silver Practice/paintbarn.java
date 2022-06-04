import java.io.*;
import java.util.*;

public class paintbarn {
    static int[][] psums = new int[1001][1001];
	public static void main(String[] args) throws IOException {
    	BufferedReader in = new BufferedReader(new FileReader("paintbarn.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                psums[j][y1]++;
                psums[j][y2]--;
            }
        }
        int count = 0;
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1000; j++) {
                if (psums[i][j] == k) count++;
                psums[i][j+1] += psums[i][j];
            }
        }
        out.println(count);
        out.close();
	}
}