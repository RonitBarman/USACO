import java.io.*;
import java.util.*;

class blocks {
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\blockgame\\in.txt"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\blockgame\\out.txt")));

        BufferedReader in = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        String[] temp = new String[2];
        int[] letters = new int[26];
        Scanner scanner = new Scanner(in);
        int len = scanner.nextInt();
        int max = 0;
        for (int i = 0; i < len; i++) {
            temp[0] = scanner.next();
            temp[1] = scanner.next();
            for (char c = 'a'; c <= 'z'; c++) {
                max = Math.max(checkWord(temp[0], c), checkWord(temp[1], c));
                letters[(int) c - 97] += max;
            }
        
        }
        scanner.close();

        for (int i = 0; i < 26; i++) {
            out.println(letters[i]);
            System.out.println(letters[i]);
        }
        out.close();

        

    }

    static int checkWord(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) count++;
        }
        return count;
    }
}