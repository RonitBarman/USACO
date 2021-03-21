import java.io.*;
import java.util.*;

class speeding {

    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\speedingticket\\in.txt"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\speedingticket\\out.txt")));

        BufferedReader in = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int len = Integer.parseInt(st.nextToken());
        int[] lim1 = new int[len];
        int[] lim2 = new int[len];
        int len2 = Integer.parseInt(st.nextToken());
        int[] jo1 = new int[len2];
        int[] jo2 = new int[len2];

        int[] tracker = new int[100];
        int[] tracker2 = new int[100];

        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(in.readLine());
            lim1[i] = Integer.parseInt(st.nextToken());
            lim2[i] = Integer.parseInt(st.nextToken());
        }

        
        for (int i = 0; i < jo1.length; i++) {
            st = new StringTokenizer(in.readLine());
            jo1[i] = Integer.parseInt(st.nextToken());
            jo2[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        for (int i = 0; i < lim1.length; i++) {
            for (int j = start; j < start+lim1[i]; j++) {
                tracker[j] = lim2[i];
            }
            start += lim1[i];
        }
        
        start = 0;
        for (int i = 0; i < jo1.length; i++) {
            for (int j = start; j < start+jo1[i]; j++) {
                tracker2[j] = jo2[i];
            }
            start += jo1[i];
        }

        
        int high = -1000;
        int diff = 0;
        for (int i = 0; i < 100; i++) {
            diff = tracker2[i] - tracker[i];
            if (diff > high) high = diff;
            System.out.println(high);
            

        }
        //System.out.println((zero == -100) ? 0 : -Collections.min(diffs));
        //out.println((zero == -100) ? 0 : -Collections.min(diffs));
        //System.out.println((high >= 0) ? high : 0);
        out.println((high >= 0) ? high : 0);
        
        in.close();
        out.close();
    }

}