import java.io.*;
import java.util.*;

public class baseball {
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("baseball.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("baseball.out")));
        int n = Integer.parseInt(in.readLine());
        int[] cows = new int[n];
        for (int i = 0; i < n; i++) cows[i] = Integer.parseInt(in.readLine());
        in.close();

        Arrays.sort(cows);
        int count = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                int d = cows[j] - cows[i];
                int l = Arrays.binarySearch(cows, cows[j]+d);
                if (l < 0) l = -l - 1;
                int r = Arrays.binarySearch(cows, cows[j]+2*d);
                if (r < 0) r = -r - 1;
                else r++;
                count += r - l;
            }
        }
        out.println(count);
        out.close();
    }
}
