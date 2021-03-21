import java.io.*;
import java.util.*;


public class citystate {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("citystate.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[][] citCheck = new boolean[26][26];
        boolean[][] abCheck = new boolean[26][26];
        String temp1 = "";
        String temp2 = "";
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            temp1 = st.nextToken();
            temp2 = st.nextToken();
            citCheck[temp1.charAt(0)-65][temp1.charAt(1)-65] = true;
            abCheck[temp2.charAt(0)-65][temp2.charAt(1)-65] = true;
        }
        int pairs = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (citCheck[i][j] && abCheck[i][j]) pairs++;
            }
        }
        System.out.println(pairs/2);
        out.println(pairs/2);
        out.close();

    }
}
