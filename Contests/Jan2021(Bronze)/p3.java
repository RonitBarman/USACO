import java.io.*;
import java.util.*;

public class p3 {

    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[n];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) b[i] = Integer.parseInt(st.nextToken());

        
        permute(a, n, b);

        System.out.println(count);
    }

    static void swap(int[] arr, int e1, int e2) {
        int obj1 = arr[e1];
        int obj2 = arr[e2];
        arr[e1] = obj2;
        arr[e2] = obj1;
    }

    static void permute(int[] cows, int s, int[] limits) {
        if (s == 1) {
            boolean valid = true;
            for (int i = 0; i < cows.length; i++) {
                if (!(cows[i] <= limits[i])) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                count++;
            }
        } else {
            permute(cows, s-1, limits);
            for (int i = 0; i < s-1; i++) {
                if (s % 2 == 0) {
                    swap(cows, i, s-1);
                } else {
                    swap(cows, 0, s-1); 
                }
                permute(cows, s-1, limits);
            }
        }
    }
}
