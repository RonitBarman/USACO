import java.io.*;
import java.util.*;

public class cownomics {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));

        //BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\bovineGenomics\\in.txt"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\bovineGenomics\\out.txt")));
                                                            
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] spotty = new char[n][m];
        char[][] plain = new char[n][m];

        for (int i = 0; i < n; i++) spotty[i] = scanner.next().toCharArray();
        for (int i = 0; i < n; i++) plain[i] = scanner.next().toCharArray();
        scanner.close();

        int count = 0;
        boolean[] check = new boolean[20];
        boolean diff = true;
        System.out.println(check[0]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check[(int) (spotty[j][i] - 65)] = true;
            }

            for (int j = 0; j < n; j++) {
                if (check[(int) (plain[j][i] - 65)]) {
                    diff = false;
                    break;
                }
            }
            if (diff) count++;
            diff = true;
            check = new boolean[20];
        }
        System.out.println(count);
        out.println(count);
        out.close();

    }
}
