import java.util.*;
import java.io.*;



class socdist2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\socdist2\\in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\socdist2\\out.txt")));

        // BufferedReader in = new BufferedReader(new FileReader("socdist2.in"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist2.out")));
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int[] cows = new int[1_000_001];
        int pos = 0;
        int n = Integer.parseInt(st.nextToken());
        int max = -1;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            pos = Integer.parseInt(st.nextToken());
            max = Math.max(max, pre);
            cows[pos] = Integer.parseInt(st.nextToken()) + 1;
            pre = pos;
        }

        for (int i = 0; i <= max; i++) {
            System.out.print(cows[i] + " ");
        }
        System.out.println();
        int prev = -1;
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i <= max; i++) {
            if (cows[i] == 0) {
                continue;
            } else {
                if (prev == -1) {
                    prev = i;
                    continue;
                }
                if (cows[i] == cows[prev]){
                    prev = i;
                    continue;
                } 
                else {
                    
                    dis = (dis < (i - prev)) ? dis : (i - prev);
                    prev = i;
                }
            }
            // } else if (cows[i] == 1 && cows[prev] == 2) {
            //     dis = (dis < i - prev) ? dis : i - prev;
            //     prev = i;
            // }
        }
        // System.out.println("\n"+"dis "+dis);
        // System.out.println("done");
        // boolean healthy = false;
        // for (int i = 0; i <= max; i ++) {
        //     if (cows[i] == 2) {healthy = true;}
        //     if ((i + 1) % dis == 0 && healthy == true) {
        //         count += 1;
        //         healthy = false;
        //     }
        // }
        int inf = 0;
        for (int i = 0; i <= max; i++) {
            if (cows[i] == 2) {
                inf++;
                i = i + dis;
            }
        }
        System.out.println(inf);
        in.close();
        out.println(inf);
        out.close();
    }
}