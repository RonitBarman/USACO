import java.util.*;
import java.io.*;

public class diamond2 {

    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("diamond.in"));
        int n = in.nextInt();
        int k = in.nextInt();  // max difference allowed in case
        int[] sizes = new int[n];
        for (int i = 0; i < n; i++) sizes[i] = in.nextInt();
        in.close();

        int result = 0;
        for (int i = 0; i < n; i++) {
            int min = sizes[i]; // i: index of the diamond that's the smallest in the case
            int max = min + k;  // anything up to exactly k units bigger than min

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (min <= sizes[j] && sizes[j] <= max) count++;
            }

            result = Math.max(result, count);
        }

        PrintWriter out = new PrintWriter(new File("diamond.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }

}
