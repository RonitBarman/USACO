import java.io.*;
import java.util.*;


public class sleepy {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("sleepy.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n+1];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int count = n-1;
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) count = i;
            else break;
        }
        // while (!sorted(nums)) {
        //     if (nums[0] == 1) move(0, n, nums);
        //     else {
        //         for (int j = n-1; j > 0; j--) {
        //             if (j != n-1) {
        //                 if (nums[j] < nums[0] && nums[j+1] > nums[0]) {
        //                     move(0, j, nums);
        //                     break;
        //                 }
        //             } else {
        //                 if (nums[j] < nums[0]) {
        //                     move(0, j, nums);
        //                     break;
        //                 }
        //             }
        //         }
        //     }
        //     for (int i = 0; i < n+1; i++) System.out.print(nums[i] + " ");
        //     System.out.print("  " +count);
        //     System.out.print("\n");
        //     count++;
        // }
        System.out.println(count);
        out.println(count);
        out.close();
    }

    static void move(int i1, int i2, int[] nums) {
        for (int c = i1; c < i2; c++) {
            swap(c, c+1, nums);
        }
    }
    static void swap(int i1, int i2, int[] ar) {
        int t1 = ar[i1];
        int t2 = ar[i2];
        ar[i1] = t2;
        ar[i2] = t1;
    }
    static boolean sorted(int[] ar) {
        int c = 2;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != c) return false;
            c++;
        }
        return true;
    }
    
}
