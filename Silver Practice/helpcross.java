import java.io.*;
import java.util.*;


public class helpcross {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("helpcross.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));

        ArrayList<Cow> cows = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] cs  = new int[c];
        for (int i = 0; i < c; i++) cs[i] = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            cows.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        in.close();
        Arrays.sort(cs);
        Collections.sort(cows);
        //for (int i = 0; i < cows.size(); i++) System.out.println(cows.get(i).b+" "+cows.get(i).e);
        int count = 0;
        int i = 0; //chickens
        int j = 0; //cows
        while (i < cs.length && j < cows.size()) {
            Cow curr = cows.get(j);
            if (curr.b <= cs[i] && curr.e >= cs[i]) {
                count++;
                i++;
                j++;
            } else if (cs[i] < curr.b) {
                i++;
            } else if (cs[i] > curr.e) {
                j++;
            }
        }
        
        //System.out.println(count);
        out.println(count);
        out.close();

    }

    static class Cow implements Comparable<Cow> {
        int b;
        int e;
        public Cow(int b, int e) {
            this.e = e;
            this.b = b;
        }

        @Override
        public int compareTo(Cow o) {
            //return (this.b+this.e)/2 - (o.b+o.e)/2;
            if (this.b - o.b != 0) return this.b - o.b;
            else return this.e - o.e;
        }
    }
    
}
// else {
    //     int j = i;
    //     int k = 0;
    //     Object[] temp = pq.toArray();
    //     while (((Cow) temp[k]).b <= cs[i] && j < n && j < pq.size()) {
    //         if (((Cow) temp[k]).b <= cs[i] && ((Cow) temp[k]).e >= cs[i]) {
    //             count++;
    //             break;
    //         }
    //         k++;
    //         j++;
    //     }
    //     System.out.println(count);
    //     pq.remove((Cow) temp[k]);
    //     // for (int d = 0; d < temp.length; d++) {
    //     //     if (d != k-1) pq.add((Cow) temp[d]);
    //     // }
    // }
    // System.out.println(count);
