import java.io.*;
import java.util.*;

public class photo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("photo.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] a = new int[n-1];
        int[] b = new int[n];
        for (int i = 0; i < n-1; i++) a[i] = Integer.parseInt(st.nextToken());

        int f = 0;
        int l = 0;
        boolean inc = false;
        if (n == 2) {
            System.out.println(1+" "+2);
            out.println(1+" "+2);
        } else {
            for (int i = 1; i <= a[0]-1; i++) {
                f = i;
                l = a[0]-i;
                for (int j = 0; j < n-2; j++) {
                    if (f != l && f+l == a[j]) {
                        b[j] = f; b[j+1] = l;
                        f = l;
                        l = a[j+1] - l;
                        if (l <= 0 || f <= 0 || l > n || f > n) {
                            inc = true;
                            break;
                        }
                    } else {
                        inc = true;
                        break;
                    }
                }
                if (inc == false) break;
                inc = false;
            }
            b[n-1] = a[n-2] - b[n-2];
            for (int i = 0; i < n; i++) System.out.print(b[i]+" ");

            for (int i = 0; i < n-1; i++) out.print(b[i]+" ");
            out.println(b[n-1]);
        }
        out.close();
    }
}
