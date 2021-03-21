import  java.util.*;
import java.io.*;


public class word {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("word.in"));
        PrintWriter out = new PrintWriter(new FileWriter("word.out"));
        int n = in.nextInt();
        int k = in.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) words[i] = in.next();
        in.close();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (count+words[i].length() <= k) {
                if (count == 0) {
                    out.print(words[i]);
                    System.out.print(words[i]);
                } else {
                    out.print(" " + words[i]);
                    System.out.print(" " + words[i]);
                }
                count += words[i].length();
            } else {
                out.print("\n");

                out.print(words[i]);

                System.out.print("\n");
                System.out.print(words[i]+" ");
                count = 0; count += words[i].length();
            }
        }
        out.println();
        out.close();
    }
    
}
