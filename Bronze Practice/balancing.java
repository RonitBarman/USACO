import java.util.*;
import java.io.*;

public class balancing {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("balancing.in")));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("balancing.out"))));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int q1 = 0; 
        int q2 = 0;
        int q3 = 0; 
        int q4 = 0;
        int m = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int b = y[j]-1;
            int a = x[j]-1;

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (x[i] < a && y[i] < b) q3++;
                    if (x[i] > a && y[i] > b) q1++;
                    if (x[i] > a && y[i] < b) q4++;
                    if (x[i] < a && y[i] > b) q2++;
                }
                m = Math.min(Collections.max(List.of(q1, q2, q3, q4)), m);
                q1 = 0; q2 = 0; q3 = 0; q4 = 0;
                a = x[k]+1;
            }
            a = x[j]-1;

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (x[i] < a && y[i] < b) q3++;
                    if (x[i] > a && y[i] > b) q1++;
                    if (x[i] > a && y[i] < b) q4++;
                    if (x[i] < a && y[i] > b) q2++;
                }
                m = Math.min(Collections.max(List.of(q1, q2, q3, q4)), m);
                q1 = 0; q2 = 0; q3 = 0; q4 = 0;
                b = y[k]+1;
            }
            b = y[j]-1;
        }        
        System.out.println(m);
        out.println(m);
        out.close();
    }
}
