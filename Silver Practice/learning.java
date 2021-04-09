import java.io.*;
import java.util.*;

public class learning {
	public static void main(String[] args) throws IOException {
    	//BufferedReader in = new BufferedReader(new FileReader("./3.in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("learning.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Cow[] cows = new Cow[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            cows[i] = new Cow((st.nextToken().equals("S")), Integer.parseInt(st.nextToken()));
        }
        in.close();
        Arrays.sort(cows);
        int total = b-a+1;
        for (int i = 0; i < cows.length; i++) {
            if (!cows[i].s) {
                System.out.println((cows[i].w-cows[i-1].w)/2 + (cows[i+1].w-cows[i].w)/2);
                total -= (cows[i].w-cows[i-1].w)/2 + (cows[i+1].w-cows[i].w)/2;
            }
        }
        //out.println(total);
        //out.close();
        System.out.println(total);
	}

    static class Cow implements Comparable<Cow> {
        int w;
        boolean s;
        Cow(boolean s, int w) {this.w = w; this.s = s;}

        @Override
        public int compareTo(Cow o) {return this.w - o.w;}
        
    }
}