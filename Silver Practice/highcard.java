import java.io.*;
import java.util.*;
// http://www.usaco.org/index.php?page=viewproblem2&cpid=571

public class highcard {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("highcard.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
        int n = Integer.parseInt(in.readLine());
        int[] nums = new int[n*2+1];
        for (int i = 0; i < n; i++) nums[Integer.parseInt(in.readLine())] = 1; 
        int wins = 0;
        for (int i = 1; i <= n*2; i++) {
            boolean temp = false;
            if (nums[i] == 1) {
                for (int j = i; j <= n*2; j++) {
                    if (nums[j] == 0 && j > i) {
                        temp = true;
                        nums[j] = 2;
                        break;
                    }
                }
            }
            if (temp) wins++;
        }
        System.out.println(wins);
        out.println(wins);
        out.close();

    }
}