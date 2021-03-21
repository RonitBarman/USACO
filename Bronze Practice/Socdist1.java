import java.io.*;
import java.util.*;

class Socdist1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\socdist1\\in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\socdist1\\out.txt")));

        //BufferedReader f = new BufferedReader(new FileReader("socdist1.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));

        
        TreeSet<Integer> counts = new TreeSet<>();


        int len = Integer.parseInt(f.readLine());
        int[] stalls = new int[len];
        String[] temp = new String[len];

        temp = f.readLine().split("");
        for (int i = 0; i < len; i++) {
            stalls[i] = Integer.parseInt(temp[i]);
        }
        
        int c = 0;
        int leng = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0 && stalls[i] == 1) {continue;}
            else if (i == len-1 && stalls[i] == 0) {
                c += 1;
                counts.add(c);
                leng += 1;
            }
            if (stalls[i] != 1) {
                c += 1;
            } else {
                counts.add(c);
                leng += 1;
                c = 0;
            }
        }
        
        counts.forEach((i) -> System.out.println(i));
        
        int tem = 0;
        int val = 0;
        boolean tru = false;
        for (int i = 0; i < counts.size(); i++) {
            if (counts.higher(2) != null) {
                System.out.println("if");
                tem = counts.higher(2);
                counts.remove(counts.higher(2));
                counts.add(1);
                counts.add(tem-2);
            } else {
                System.out.println("not");
                tru = false;
                if (leng > 2) {
                    val = 2;
                } else {
                    val = 1;
                }
            }
        }

        int rvalue = (tru == false) ? Collections.max(counts) : val;
        
        System.out.println(rvalue);
        out.println(rvalue);
        out.close();
        f.close();

        
    }
}