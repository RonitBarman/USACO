import java.io.*;
import java.util.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=595
public class div7 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("div7.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));   

        int n = Integer.parseInt(in.readLine());
        int[] psums = new int[n+1];
        for (int i = 0; i < n; i++) {
            psums[i+1] = Integer.parseInt(in.readLine())+psums[i];
        }

        
        int max = -1;
        for (int i = 0; i < n+1; i++) {
            for (int j = i+1; j < n+1; j++) {
                //System.out.println(psums[j]-psums[i]+" S");
                if ((psums[j]-psums[i]) % 7 == 0) {
                    //System.out.println(psums[j]-psums[i]+" S");
                    max = Math.max(j-i, max);
                }
            }
        }
        System.out.println(max);
        out.println(max);
        out.close();

    }
}
