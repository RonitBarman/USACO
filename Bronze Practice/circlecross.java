import java.io.*;
import java.util.*;

public class circlecross {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("circlecross.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));

        char[] letters = new char[52];
        letters = in.readLine().toCharArray();
        int b = 0;
        int e = 0;
        int num = 0;
        for (char l = 'A'; l <= 'Z'; l++) {
            for (int i = 0; i < 52; i++) if (letters[i] == l) {
                b = i;
                break;
            }
            for (int i = b+1; i < 52; i++) if (letters[i] == l) {
                e = i;
                break;
            }
            
            for (int i = b+1; i < e; i++) {
                if (!ends(letters[i], letters, b, e)) {
                    num++;
                    System.out.println(letters[i]);
                }
            }
        }

        System.out.println(num/2);
        out.println(num/2);
        out.close();
    }
    static boolean ends(char c, char[] array, int b, int e) {
        int count = 0;
        for (int i = b+1; i < e; i++) {
            if (array[i] == c) count++;
        }
        if (count == 2) return true;
        else return false;
            
    }


}
