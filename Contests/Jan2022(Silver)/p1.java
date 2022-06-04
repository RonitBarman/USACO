import java.io.*;
import java.util.*;

public class p1 {
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("p1.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("p1.out")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long ops = 0L;
            boolean even = b % 2 == 0;
            boolean alt = false;
            while (a != b) {
                if (a < b) {
                    // if (!alt) {
                        long temp = a;
                        a = b;
                        b = temp;
                        alt = true;
                    // }
                }
                if (b - a == 1 || b - a == 2) {
                    ops += b - a;
                    break;
                }
                if (alt) {
                    if (a - b == 1 || a - b == 2) {
                        ops += a - b;
                        break;
                    }
                }
                if (a > b) {
                    if (a % 2 == 0) {
                        a /= 2;
                        ops++;
                    } else if (a % 2 == 1) {
                        if (alt) a -= 1;
                        else a += 1;
                        ops++;
                        if (a == b) break;
                        a /= 2;
                        ops++;
                    }
                }
                System.out.println(a + " a |" + b + " b " + ops + "o " + alt);
            }
            System.out.println(ops);
        }
    }
}