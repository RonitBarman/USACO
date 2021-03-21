import java.util.*;
import java.io.*;


public class gymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("gymnastics.in")));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] sessions = new int[k][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                sessions[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    if (consistent(i, j, sessions)) count++;
                }
            }
        }
        out.println(count);
        out.close();
        System.out.println(count);
    }

    public static boolean consistent(int n1, int n2, int[][] array) {
        boolean consis = false;
        for (int i = 0; i < array.length; i++) {
            if (indexOf(n1, array[i]) < indexOf(n2, array[i])) consis = true;
            else {
                consis = false;
                break;
            }
        }
        return consis;
    }
    public static int indexOf(int num, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) return i;
        }
        return -1;
    }
}
