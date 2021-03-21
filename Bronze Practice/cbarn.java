import java.util.*;
import java.io.*;

class cbarn {
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\circularbarn\\in.txt"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\circularbarn\\out.txt")));

        BufferedReader in = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] barn = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            barn[i] = Integer.parseInt(st.nextToken());
        }
        in.close();
        
        int c = 0;
        int sum = 0;
        int sol = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            c = 0;
            for (int j = i; c < n; j++) {
                if (j >= barn.length) { j = 0; }
                sum += c*barn[j];
                
                c++;
            }
            sol = (sol > sum) ? sum:sol;
            sum = 0;
        }

        out.println(sol);
        out.close();
    }
}