import java.util.*;
import java.io.*;

public class revegetate {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("revegetate.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] adjlst = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            adjlst[i][0] = Integer.parseInt(st.nextToken());
            adjlst[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) digits[i] = 1;
        while (!check(adjlst, digits)) {
            for (int i = 0; i < m; i++) {
                if (digits[adjlst[i][0]-1] == digits[adjlst[i][1]-1]) {
                    if (adjlst[i][0] > adjlst[i][1]) {
                        if (digits[adjlst[i][1]-1] + 1 > n) digits[adjlst[i][0]-1] = digits[adjlst[i][1]-1] - 1;
                        else digits[adjlst[i][0]-1] = digits[adjlst[i][1]-1] + 1;
                    } else {
                        if (digits[adjlst[i][0]-1] + 1 > n) digits[adjlst[i][1]-1] = digits[adjlst[i][0]-1] - 1;
                        else digits[adjlst[i][1]-1] = digits[adjlst[i][0]-1] + 1;
                    }
                }
                //for (int j = 0; j < digits.length; j++) System.out.print(digits[j]+" ");
                //System.out.print("\n");
            }
        }
        for (int i:digits) System.out.print(i);
        for (int i:digits) out.print(i);
        out.close();

        
    }
    static boolean check(int[][] adjlst, int[] digits) {
        for (int i = 0; i < adjlst.length; i++) {
            if (digits[adjlst[i][0]-1] == digits[adjlst[i][1]-1]) return false;
        }
        return true;
    }
}
