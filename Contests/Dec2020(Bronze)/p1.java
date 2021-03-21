import java.io.*;
import java.util.*;

public class p1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[7];
        for (int i = 0; i < 7; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);

        int a = nums[0];
        int[] nums2 = new int[4];
        int count = 0;
        int cn = 0;
        int abc = nums[6];
        int bc = abc - a;
        int bcind = 0;
        int abcind = 0;
        for (int i = 0; i < 7; i++) {
            if (nums[i] == bc) bcind = i;
            if (nums[i] == abc) abcind = i;
        }
        for (int i = 0; i < 7; i++) {
            if ((i == bcind) || (i == abcind) || (i == 0)) {
            
                continue;
            } else {
                nums2[count] = nums[i];
                count++;
            }
        }
        
        // for (int i = 0; i < 4; i++) System.out.print(nums2[i]+" ");
        // System.out.println();

        //for (int i = 0; i < 4; i++) nums2[i] -= nums[6];
        Arrays.sort(nums2);
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (nums2[i] == nums2[j] - a) {
                    temp = nums2[j] - a;
                }
            }
        }
        

        int c = (temp > bc - temp) ? temp:bc-temp;
        int b = (c == bc-temp) ? temp:bc-temp;
        System.out.println(a+" "+ b +" "+ c);
    
    }
}