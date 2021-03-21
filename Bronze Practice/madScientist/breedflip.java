import java.util.*;
import java.io.*;

public class breedflip {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("breedflip.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
    
        int n = Integer.parseInt(in.readLine());
        String a = in.readLine();
        String b = in.readLine();
        in.close();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (a.charAt(i) != b.charAt(i)) count++;
            } else {
                if (a.charAt(i-1) != b.charAt(i-1) && a.charAt(i) != b.charAt(i)) continue;
                else if (a.charAt(i) != b.charAt(i)) count++;
            }
        }

        out.println(count);
        out.close();
    }
}
