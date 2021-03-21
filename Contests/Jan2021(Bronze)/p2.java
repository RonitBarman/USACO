import java.io.*;
import java.util.*;

public class p2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String alpha = in.readLine();
        String letters = in.readLine();

        String let = "";
        int c = 0;
        int round = 0;
        boolean done = false;
        while (!done) {
            for (int i = 0; i < alpha.length(); i++) {
                if (alpha.charAt(i) == letters.charAt(c)) {
                    c++;
                    if (c == letters.length()) {
                        round++;
                        done = true;
                        break;
                    }
                }
            }
            if (!done) round++;
        }
        System.out.println(round);

    }
}
