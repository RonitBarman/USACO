import java.util.*;
import java.io.*;

class backforth {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("out.txt")));
        HashSet<Integer> dist = new HashSet<>();
        int it = 0;
        

        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < 10; i++) 
            dist.add(Integer.parseInt(st.nextToken()));
        
        
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < 10; i++) 
            dist.add(Integer.parseInt(st.nextToken()));
        int[] nums = new int[dist.size()];

        for (int i: dist) {
            nums[it] = i;
            it++;
        }

        f.close();
        out.close();

    }

    void perm(int[] ar, int ind, int[] data, int last, int[][] rr) {
        int[][] rv = rr;
        
        int len = ar.length;

        for (int i = 0; i < len; i++) { 
            if (ind == last) {

            }
        }

    }


}