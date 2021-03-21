import java.io.*;
import java.util.*;

public class shell {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("shell.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] guesses = new int[n];
        int[][] swaps = new int[n][2];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            swaps[i][0] = Integer.parseInt(st.nextToken());
            swaps[i][1] = Integer.parseInt(st.nextToken());
            guesses[i] = Integer.parseInt(st.nextToken());
        }
        int[] shells = new int[3];
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            shells[i] = 1;
            for (int j = 0; j < n; j++) {
                swap(swaps[j][0]-1, swaps[j][1]-1, shells);
                if (guesses[j]-1 == oneLoc(shells)) count++;
            }
            System.out.println(count);
            max = (count > max) ? count:max;
            shells = new int[3];
            count = 0;
        }
        System.out.println(max);
        out.println(max);
        out.close();
      
    }

    static void swap(int i1, int i2, int[] ar) {
        int t1 = ar[i1];
        int t2 = ar[i2];
        ar[i1] = t2;
        ar[i2] = t1;
    }
    static int oneLoc(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == 1) return i;
        }
        return -1;
    }
    
    
}
