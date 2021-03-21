import java.io.*;
import java.util.*;

public class race {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("race.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = Integer.parseInt(in.readLine());

        
        for (int i = 0; i < n; i++) {
            int time = 0;
            int ltravel = 0;
            int rtravel = 0;
            for (int speed = 1;; speed++) {
                ltravel += speed;
                time++;
                if (ltravel+rtravel >= k) break;
                if (speed >= x[i]) {
                    rtravel += speed;
                    time++;
                    if (ltravel+rtravel >= k) break;
                }
            }
            System.out.println(time+"c");
            out.println(time);
        }
        out.close();
    }
}
