import java.io.*;
import java.util.*;


public class cowsignal {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\cowSignal\\in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\cowSignal\\out.txt")));

        //BufferedReader in = new BufferedReader(new FileReader("cowsignal.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        
        StringTokenizer st = new StringTokenizer(in.readLine());        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[][] signal = new String[k*m][k*n];
        String[] curr = new String[n];
        int rows = 0;
        int cols = 0;


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            curr = st.nextToken().split("");
            for (int j = 0; j < n; j++) {
                for (int r = rows; r < rows+k; r++) {
                    for (int c = cols; c < cols+k; c++) {
                        signal[r][c] = curr[j];
                    }
                }
                cols += k;
            }
            rows += k;
            cols = 0;
        }
        in.close();

        for (int i = 0; i < k*m; i++) {
            for (int j = 0; j < k*n; j++) {
                if (j == k*n - 1) out.println(signal[i][j]);
                else out.print(signal[i][j]);
            }
        }
        /*
        out.println("_____________________");
        for (int i = k*m-1; i >= 0; i--) {
            for (int j = k*n-1; j >= 0; j--) {
                if (j == 0) out.println(signal[i][j]);
                else out.print(signal[i][j]);
            }
        }
        */
        out.close();

    }
}
