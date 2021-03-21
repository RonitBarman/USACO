import java.util.*;
import java.io.*;

public class hoofball {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("hoofball.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] cows = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) cows[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cows);
        boolean fin = false;
        for (int i = 2; fin == false; i++) {
            
        }
    }
}
