// "Why Did the Cow Cross the Road III" - cowqueue
// http://usaco.org/index.php?page=viewproblem2&cpid=713

import java.util.*;
import java.io.*;

public class cowQueue2 {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("cowqueue.in"));
    
    int n = in.nextInt();
    Cow[] cows = new Cow[n];
    for (int i = 0; i < n; i++) {
        cows[i] = new Cow(in.nextInt(), in.nextInt());
    }
    in.close();
    
    Arrays.sort(cows);
    int result = 0;
    for (int i = 0; i < n; i++) {
        if (cows[i].t >= result) result = cows[i].t + cows[i].q;
        else result += cows[i].q;
    }

    
    PrintWriter out = new PrintWriter(new File("cowqueue.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
  
  static class Cow implements Comparable<Cow> {
      public int t;
      public int q;
    
    public Cow(int t, int q) {
        this.q = q;
        this.t = t;
    }
    
    public int compareTo(Cow other) {
        if (this.t < other.t) return  -1;
        if (this.t > other.t) return 1;
        if (this.t == other.t) {
            if (this.q < other.q) return -1;
            if (this.q > other.q) return 1;
        }
        return 0;
    }
  }
}
