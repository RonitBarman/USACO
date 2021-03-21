import java.io.*;
import java.util.*;

public class outofplace {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("outofplace.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));

        int n = Integer.parseInt(in.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(in.readLine());
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        int bessie = 0;
        for (int i = 1; i < n; i++) {
            // if (i == 0) {
            //     if (nums[i] > nums[i+1]) {
            //         bessie = i;
            //         break;
            //     }
            // } else if (i == n-1) {
            //     if (nums[i] < nums[i-1]) {
            //         bessie = i;
            //         break;
            //     }
            // } else if (i == 2) {
            //     if (!(nums[i] >= nums[i-1]) && !(nums[i] <= nums[i+2]))
            //     else if (!(nums[i] >= nums[i-2]) && !(nums[i] <= nums[i+2])) {
            //     bessie = i;
            // }
            if (!(nums[i] <= nums[i+1])) {
                if (i < n-2) {
                    if (nums[i] > nums[i+2]) bessie = i;
                    else bessie = i+1;
                } else bessie = i+1;
                break;
            }
        }

        
        System.out.println(nums[n-1]+" "+nums[n-2]+" n");
        int h = nums[bessie];
        int correct = 0;
        for (int i = 0; i < n; i++) {
            if (copy[i] == h) {
                correct = i;
                break;
            }
        }
        HashSet<Integer> vals = new HashSet<>();
        if (correct < bessie) {
            for (int i = correct; i < bessie; i++) {
                vals.add(nums[i]);
            }
        } else {
            for (int i = correct; i >= bessie; i--) vals.add(nums[i]);
        }

        int val = 0;
        if (Math.abs(correct-bessie) == 1) val = 1;
        else val = vals.size();

        System.out.println(vals.size());
        out.println(vals.size());
        out.close();
    }
}