import java.util.*;
import java.io.*;

public class balancing2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("balancing.in")));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("balancing.out"))));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());

        Cow[] hcow = new Cow[n];
        Cow[] vcow = new Cow[n];
        int[] xcn = new int[1_000_001];
        int[] ycn = new int[1_000_001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xcn[x]++; ycn[y]++;
            hcow[i] = new Cow(x, y);
            vcow[i] = new Cow(x, y);
        }
        
        Arrays.sort(vcow, new Comparator<Cow>() {
            public int compare(Cow a, Cow b) {
                return a.y - b.y;
            }
        });
        Arrays.sort(hcow, new Comparator<Cow>() {
            public int compare(Cow a, Cow b) {
                return a.x - b.x;
            }
        });

        int q1 = 0, q2 = 0, q3 = 0, q4 = 0;
        int m = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int b = vcow[j].y-1;
            int a = hcow[j].x-1;

        
            if (hcow[j].x < a && hcow[j].x < b) q3++;
            if (hcow[j].x > a && hcow[j].x > b) q1++;
            if (hcow[j].x > a && hcow[j].x < b) q4++;
            if (hcow[j].x < a && hcow[j].x > b) q2++;
            
            for (int i = 0; i < n; i++) {
                
            }
            
            for (int k = 0; k < n; k++) {
                q1 -= xcn[hcow[k].x];
                q2 += xcn[hcow[k].x];
                m = Math.min(Collections.max(List.of(q1, q2, q3, q4)), m);
                //q1 = 0; q2 = 0; q3 = 0; q4 = 0;
                a = hcow[k].x+1;
            }
            a = hcow[j].x-1;

            for (int k = 0; k < n; k++) {
                q1 -= ycn[vcow[k].y];
                q4 += ycn[vcow[k].y];
                m = Math.min(Collections.max(List.of(q1, q2, q3, q4)), m);
                //q1 = 0; q2 = 0; q3 = 0; q4 = 0;
                b = vcow[k].y+1;
            }
            
        }        
        System.out.println(m);
        out.println(m);
        out.close();
    }


    static class Cow {
        int x,y;
        Cow(int x, int y) {this.x = x; this.y = y;}
    }
}
