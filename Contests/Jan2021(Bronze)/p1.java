import java.io.*;
import java.util.*;

public class p1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = in.nextInt();

        boolean[] pick = new boolean[n];
        boolean even = true;    
        int group = 0;
        while (!allpicked(pick)) {
            boolean done = false;
            if (even) {
                for (int i = 0; i < n; i++) {
                    if (nums[i]%2 == 0 && !pick[i]) {
                        pick[i] = true;
                        done = true;
                        //System.out.println(nums[i]);
                        break;
                    }
                }
                int c = 0;
                int i1 = 0;
                int i2 = 0;
                if (!done) {
                    for (int i = 0; i < n; i++) {
                        if (nums[i]%2 != 0 && !pick[i]) {
                            //System.out.print(nums[i]+" ");
                            //pick[i] = true;
                            if (c == 0) i1 = i;
                            else if (c == 1) i2 = i;
                            c++;
                            if (c == 2) {
                                pick[i1] = true; pick[i2] = true;
                                //System.out.print("\n");
                                done = true;
                                break;
                            }
                        }
                    }
                }
                if (done) group++;
                else {
                    //System.out.println("here");
                    //System.out.println(evenCount(nums, pick));
                    if (oddCount(nums, pick) == 1) group -= 1;
                }
                even = false;
                if (!done) for (int i = 0; i < n; i++) if (!pick[i]) pick[i] = true;
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i]%2 != 0 && !pick[i]) {
                        pick[i] = true;
                        //System.out.println(nums[i]);
                        done = true;
                        break;
                    }
                }
                boolean epick = false;
                boolean opick = false;
                if (!done) {
                    for (int i = 0; i < n; i++) {
                        if (nums[i]%2 == 0 && !pick[i]) {
                            pick[i] = true;
                            epick = true;
                            //System.out.print(nums[i]+" ");
                        } else if (nums[i]%2 != 0 && !pick[i]) {
                            //System.out.print(nums[i]+" ");
                            opick = true;
                            pick[i] = true;
                        }
                        //System.out.println(epick+" "+opick);
                        if ((epick==true) && (opick==true)) {
                            //System.out.println("here");
                            done = true;
                            break;
                        }
                    }
                }
                
                if (done) group++;
                else {
                    if (oddCount(nums, pick) == 1) group -= 1;
                }
                even = true;
                if (!done) for (int i = 0; i < n; i++) if (!pick[i]) pick[i] = true;
            }
        }
        //System.out.print("\n");
        System.out.println(group);

    }
    static boolean allpicked(boolean[] pick) {
        for (int i = 0; i < pick.length; i++) if (!pick[i]) return false;
        return true; 
    }
    static int oddCount(int[] nums, boolean[] pick) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2 != 0 && !pick[i]) c++;
        }
        return c;

    }
    static int evenCount(int[] nums, boolean[] pick) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2 == 0 && !pick[i]) c++;
        }
        return c;
    }


}
