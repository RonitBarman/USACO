import java.io.*;
import java.util.*;

public class moobuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("moobuzz.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int ans = 0;
        if (n > 8) ans = f(n);
        else ans = o(n);

        System.out.println(ans);
        out.println(ans);
        out.close();
    }
    static int f(int x) {
        if (x % 8 == 0) return o(x % 8) + 15*(x / 8) - 1;
        return o(x % 8) + 15*(x / 8);
    }
    static int o(int x) {
        int s = 1;
        for (int i = 0; i < x; i++) {
            if (s % 3 == 0 || s % 5 == 0) i--;
            s++;
        }
        return s - 1;
    }
}