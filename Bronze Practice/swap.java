import java.util.*;
import java.io.*;

/**
 * swap
 */
public class swap {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("swap.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));

        //Scanner scanner = new Scanner(new File("C:\\Users\\ronit\\RandomJava\\USACO\\swap\\in.txt"));
        //PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\swap\\out.txt"));

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int b2 = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) nums[i] = i+1;

        // for (int ine:nums) System.out.print(ine+" ");
        // System.out.println();
        // move(nums, 0, 3);
        // for (int ine:nums) System.out.print(ine+" ");


        for (int i = 0; i < k; i++) {
            for (int j = 0; j <= (a2-a1)/2; j++) {
                swa(nums, a1-1+j, a2-1-j);
            }
            // for (int ine:nums) System.out.print(ine+" ");
            // System.out.println();
            for (int j = 0; j <= (b2-b1)/2; j++) {
                swa(nums, b1-1+j, b2-1-j);
            }
        }

        for (int i = 0; i < n; i++) out.println(nums[i]);
        out.close();
    }

    static void swa(int[] arr, int i1, int i2) {
        int obj1 = arr[i1];
        int obj2 = arr[i2];
        arr[i2] = obj1;
        arr[i1] = obj2;
    }
    // static void move(int[] arr, int i1, int i2) {
    //     if (i1 < i2) {
    //         for (int ind = i1; ind < i2; ind++) swa(arr, ind, ind+1);
    //     } else {
    //         for (int ind = i2; ind > i1; ind--) swa(arr, ind, ind-1);        
    //     }
    // }
}

// int[] temp = new int[a2-a1+1];
// int ind = 0;
// for (int j = a2-1; j >= a1-1; j--) {
//     temp[ind] = nums[j];
//     ind++;
// }

// ind = 0;
// for (int j = a1-1; j <= a2-1; j++) {
//     nums[j] = temp[ind];
//     ind++;
// }
// // for (int ine:nums) System.out.print(ine+" ");
// // System.out.println();
// temp = new int[b2-b1+1];
// ind = 0;
// for (int j = b2-1; j >= b1-1; j--) {
//     temp[ind] = nums[j];
//     ind++;
// }
// ind = 0;
// for (int j = b1-1; j <= b2-1; j++) {
//     nums[j] = temp[ind];
//     ind++;
// }
// // for (int ine:nums) System.out.print(ine+" ");
// // System.out.println();