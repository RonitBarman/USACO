import java.io.*;
import java.util.*;

class escape {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("escape.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("escape.out")));
        n = Integer.parseInt(in.readLine());
        int[] cows = new int[n];
        for (int i = 0; i < n; i++) cows[i] = Integer.parseInt(in.readLine());
        in.close();
        HashSet<String> subsets = new HashSet<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            String subset = "";
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) subset += cows[j]+" ";
            }
            subsets.add(subset);
        }   
        int max = -1;
        for (String set : subsets) {
            if (set != null) {
                String[] list = set.split(" ");
                int[] nums = new int[list.length];
                for (int i = 0; i < nums.length; i++) if (!list[i].isBlank()) {
                    nums[i] = Integer.parseInt(list[i]);
                }
                if (!carryOver(nums)) max = Math.max(nums.length, max);
            }
        }
        
        System.out.println(max);
        out.println(max);
        out.close();
    }

    static boolean carryOver(int[] nums) {
        while (check(nums)) {
            if (modSum(nums) >= 10) return true;
            div(nums);
        }
        return false;
    }
    static boolean check(int[] nums) {
        for (int i : nums) if (i <= 0) return false;
        return true;
    }
    static int modSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i] % 10;
        return sum;
    }

    static void div(int[] nums) {
        for (int i = 0; i < nums.length; i++) nums[i] /= 10;
    }
}