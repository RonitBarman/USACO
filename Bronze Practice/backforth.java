import java.util.*;
import java.io.*;

class backforth {
    public static void main(String[] args) {
        BufferedReader f = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));

        int ans = 0;
        int[] bkts1 = new int[10];
        int[] bkts2 = new int[10];

        HashSet<Integer> distinct = new HashSet<>();

        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < 10; i++) 
            bkts1[i] = Integer.parseInt(st.nextToken());
        
        
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < 10; i++) 
            bkts1[i] = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                ans = 1000 - bkts1[i] + bkts2[i] - bkts1[i+1] + bkts2[j+1];
            }

        }

    }
}