import java.io.*;
import java.util.*;

public class maxcross {
    public static void main(String[] args) throws IOException {
        int a = 0;
        int bc = 0;
        List<Integer> li = List.of(a, bc);
        BufferedReader in = new BufferedReader(new FileReader("maxcross.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] signals = new int[b];
        for (int i = 0; i < b; i++) signals[i] = Integer.parseInt(in.readLine());
        Arrays.sort(signals);
        
        int[] diffs = new int[b+1];
        for (int i = 1; i < b; i++) diffs[i] = signals[i] - signals[i-1] - 1;
        diffs[0] = (signals[0]-2 > 1) ? signals[0]-2 : 0;
        diffs[b] = ((n - signals[b-1] - 1) > 0) ? n - signals[b-1] - 1 : 0;
        int maxD = 0;
        
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            pairs.add(new Pair(signals[i], diffs[i]+diffs[i+1]+1));
        }
        Collections.sort(pairs);
        int i = 0;
        //for (int l : diffs) System.out.println(l + " l");
        //for (Pair p : pairs) System.out.println(p.x+" "+p.y);
        while (maxD < k) {
            maxD += pairs.get(i).x;

            i++;
        }
        System.out.println(i);
        
        out.println(i);
        out.close();
        
    }
    

    static class Pair implements Comparable<Pair> {
        int x,y;
        Pair(int x, int y) { this.x = x; this.y = y; }

        @Override
        public int compareTo(Pair o) {
            return o.x - this.x;
        }
        @Override
        public boolean equals(Object obj) {
            Pair pair = (Pair) obj;
            if (this.y == pair.y && this.x == pair.x) return true;
            else return false;
        }
    }

    static Pair maxPair(ArrayList<Pair> pairs) {
        int max = Integer.MIN_VALUE;
        int maxx = -1;
        for (int i = 0; i < pairs.size(); i++) {
            max = Math.max(pairs.get(i).y, max);
            maxx = pairs.get(i).x;
        }
        return new Pair(maxx, max);
    }
}