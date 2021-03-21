import java.io.*;
import java.util.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=666

public class haybales {
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("haybales.in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] locs = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) locs[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(locs);
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int li = Arrays.binarySearch(locs, l);
            int hi = Arrays.binarySearch(locs, h);
            if (hi < 0 && li < 0) {
                System.out.println(0);
                //out.println(0);
            } else if (li < 0) {
                if (hi >= 0) {
                    int ind = hi;
                    for (int c = hi; c >= 0; c--) {
                        if (locs[c] > l) {
                            ind--;
                        } else break;
                    }
                    System.out.println(hi-ind+1+" ANS");
                    //out.println(hi-ind+1);
                }
            } else if (hi < 0) {
                if (li >= 0) {
                    int ind = li;
                    for (int c = li; c < n; c++) {
                        if (locs[c] < h) {
                            ind++;
                        } else break;
                    }
                    System.out.println(hi-ind+1+" ANS");
                    //out.println(hi-ind+1);
                }
            } else {
                System.out.println(hi-li+1+" ANS");
                //out.println(hi-li+1);
            }
            
        }
    }
}