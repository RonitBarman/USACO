import java.io.*;
import java.util.*;

public class censor {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("censor.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));
        ArrayList<String> words = new ArrayList<>();
        String temp = in.readLine();
        for (int i = 0; i < temp.length(); i++) {
            words.add(temp.charAt(i)+"");
        }

        temp = in.readLine();
        
        ArrayList<String> t = new ArrayList<>();
        for (int i = 0; i < temp.length(); i++) {
            t.add(temp.charAt(i)+"");
        }
        System.out.println(words.size()+" "+t.size());
        boolean equal = true;
        while (words.containsAll(t)) {
            for (int i = 0; i < words.size()-t.size(); i++) {
                for (int j = 0; j < t.size(); j++) {
                    if (!words.get(i+j).equals(t.get(j))) {
                        equal = false;
                        break;
                    }
                }
                int c = 0;
                if (equal) {
                    for (int j = i; j < i+t.size(); j++) {
                        System.out.println(words.get(j-c));
                        words.remove(j-c);
                        c++;
                    }
                }
                equal = true;
                //for (String s:words) System.out.print(s);
                //System.out.print("\n");
            }
            
        }
        for (int i = 0; i < words.size(); i++) System.out.print(words.get(i));
        for (int i = 0; i < words.size(); i++) out.print(words.get(i));
        out.close();

    }
}