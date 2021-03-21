import java.util.*;

import java.io.*;


public class lineup {
    public static void main(String[] args) throws  IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("C:\\Users\\ronit\\RandomJava\\USACO\\livestockLineup\\in.txt")));
        PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\livestockLineup\\out.txt"));
        String[] cows = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[][] restrictions = new String[2][n];
        String[] temp = new String[6];

        for (int i = 0; i < n; i++) {
            temp = in.readLine().split(" ");
            restrictions[0][i] = temp[5];
            restrictions[1][i] = temp[0];
        }
        in.close();

        move(cows, 2, 7);
        for (String str: cows) System.out.print(str+" ");
        // TreeMap<String[], Integer> combos = new TreeMap<>(Arrays::compare);
        // permute(cows, 8, restrictions, combos);
        // System.out.println(combos.size()+" S");
        // for (String str : combos.firstKey()) {
        //     out.println(str);
        //     System.out.println(str+"8");
        // }
        out.close();

    }

    

    static void swap(Object[] arr, int e1, int e2) {
        Object obj1 = arr[e1];
        Object obj2 = arr[e2];
        arr[e1] = obj2;
        arr[e2] = obj1;
    }

    static void move(Object[] array, int i1, int i2) {
        Object value = array[i1];
        int ind = 0;
        if (i1 < i2) {
            ind = i1;
            while (ind < i2) {
                swap(array, ind, ind+1);
                ind++;
            }
        } else {
            ind = i1;
            while (ind > i2) {
                swap(array, ind, ind-1);
                ind--;
            }
        }
    }
}
// static void permute(String[] cows, int s, String[][] restrictions, TreeMap<String[], Integer> combos) {
    //     boolean check = false;
    //     if (s == 1) {
    //         //System.out.println(cows[0]);
    //         for (int i = 0; i < restrictions[0].length; i++) {
    //             check = false;
    //             for (int j = 0; j < cows.length-1; j++) {
    //                 if ((cows[j].equals(restrictions[0][i]) && cows[j+1].equals(restrictions[1][i])) || (cows[j].equals(restrictions[1][i]) && cows[j+1].equals(restrictions[0][i]))) {
    //                     check = true;
    //                     break;
    //                 }
    //             }
    //             if (check == false) break;
    //         }
    //         if (check) {
    //             System.out.print(cows[0]+" "+cows[7]);
    //             combos.put(cows, 0);
    //             System.out.println(combos.size());    
    //         }
    //     } else {
    //         permute(cows, s-1, restrictions, combos);
    //         for (int i = 0; i < s-1; i++) {
    //             if (s % 2 == 0) {
    //                 swap(cows, i, s-1);
    //             } else {
    //                 swap(cows, 0, s-1); 
    //             }
    //             permute(cows, s - 1, restrictions, combos);
    //         }
    //     }
    // }