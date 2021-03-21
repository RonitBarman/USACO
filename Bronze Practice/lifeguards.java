import java.util.*;
import java.io.*;


public class lifeguards {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("lifeguards.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] guards = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            guards[i][0] = Integer.parseInt(st.nextToken());
            guards[i][1] = Integer.parseInt(st.nextToken());
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int[] time = new int[1001];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) fill(time, guards[j][0], guards[j][1]);
            }
            for (int num:time) sum += num;
            maxSum = (sum > maxSum) ? sum:maxSum;
            sum = 0;
            time = new int[1001];
        }
        System.out.println(maxSum);
        out.println(maxSum);
        out.close();
    }

    static void fill(int[] array, int t1, int t2) {
        for (int i = t1; i < t2; i++) array[i] = 1;
    }
}
