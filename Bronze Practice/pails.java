import java.io.*;
import java.util.*;


public class pails {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("pails.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    
        int m1 = m/x;
        int m2 = m/y;
        int max = Integer.MIN_VALUE;
        int num = 0;
        for (int i = 0; i <= m2; i++) {
            for (int j = 0; j <= m1; j++) {
                num = (x*j) + (y*i);
                if (num <= m) max = (num > max) ? num:max;
            }
        }
        System.out.println(max);
        out.println(max);
        out.close();
        
        
        
    }
}
