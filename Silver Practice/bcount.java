import java.io.*;
import java.util.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=572
public class bcount {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("bcount.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] psums = new int[3][n+1];
        int h = 0;
        int g = 0; 
        int j = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(in.readLine());
            if (temp == 1) h++; psums[0][i+1] = h;
            if (temp == 2) g++; psums[1][i+1] = g;
            if (temp == 3) j++; psums[2][i+1] = j;
        }
        //System.out.println(h + " "+ g+" "+j);
        for (int i = 0; i < q; i++) {
            int q1 = 0;
            int q2 = 0;
            st = new StringTokenizer(in.readLine());
            q1 = Integer.parseInt(st.nextToken());
            q2 = Integer.parseInt(st.nextToken());
            System.out.println((psums[0][q2]-psums[0][q1-1])+" "+(psums[1][q2]-psums[1][q1-1])+" "+(psums[2][q2]-psums[2][q1-1]));
            out.println((psums[0][q2]-psums[0][q1-1])+" "+(psums[1][q2]-psums[1][q1-1])+" "+(psums[2][q2]-psums[2][q1-1]));
        }
        out.close();
        
    }
    
}
