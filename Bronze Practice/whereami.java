import java.io.*;
import java.util.*;


public class whereami {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("whereami.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        String letters = in.readLine();
        
        int min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i <= letters.length(); i++) {
            for (int j = 0; j <= letters.length()-i; j++) {
                set.add(letters.substring(j, j+i));
            }
            if (set.size() == letters.length()-i+1) min = (i < min) ? i:min;
            set = new HashSet<>();
        }
        System.out.println(min);
        out.println(min);
        out.close();
    }

    static int contains (String sub, String string) {
        int c = 0;
        for (int i = 0; i <= string.length()-sub.length(); i++) {
            if (string.substring(i, i+sub.length()).equals(sub)) c++;
        }
        return c;
    }
    
}
