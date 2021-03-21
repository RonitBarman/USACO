import java.io.*;
import java.util.*;
//
public class cowdance {

    static int n;
    static int[] times;
    static int tm;
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("cowdance.in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out"))); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        n = Integer.parseInt(st.nextToken());
        times = new int[n];
        tm = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            times[i] = Integer.parseInt(st.nextToken());
        }

    }

    static boolean valid(int k) {
        int num = 0;
        int c = 0;
        for (int i = 0; i < tm; i++) {
            for (int j = num; j < ((k+num > n) ? n:k+num); j++) {
                if (times[j]==0) {
                    c++;
                }
                else times[j] -= 1;
            }
            if (c==k);
        }
        return false;
    }



}