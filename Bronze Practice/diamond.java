import java.io.*;
import java.util.*;

public class diamond {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));

        //BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\diamondcollector\\in2.txt"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\diamondcollector\\out.txt")));


        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dlist = new int[n];
        

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            dlist[i] = Integer.parseInt(st.nextToken());
        }
        in.close();
       
        
        ArrayList<Integer> temp = new ArrayList<>();
        int maxlen = -1;
        for (int i = 0; i < dlist.length; i++) {
            temp = new ArrayList<>();
            temp.add(dlist[i]);

            for (int j = 0; j < dlist.length; j++) {
                if (j == i) continue;
                boolean conditionMet = true;

                for (int l = 0; l < temp.size(); l++) {
                    if (Math.abs(dlist[j] - temp.get(l)) > k) {
                        conditionMet = false; 
                        break;
                    }
                }
                if (conditionMet) temp.add(dlist[j]);
            }
            if (temp.size() > maxlen) {
                maxlen = temp.size();
                System.out.println(maxlen);
            }
        }

        
        // System.out.println(maxlen);
        out.println(maxlen);
        out.close();
    }
}
