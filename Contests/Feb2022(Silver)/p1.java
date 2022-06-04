import java.io.*;
import java.util.*;

public class p1 {
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("p1.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("p1.out")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        ArrayList<Integer[]> pref = new ArrayList<>();
        boolean[] taken = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            Integer[] temp = new Integer[n + 1];
            temp[n] = i;
            pref.add(temp);
            for (int j = 0; j < n; j++) {
                pref.get(i)[j] = Integer.parseInt(st.nextToken());
            }
        }
        // Collections.sort(pref, new Comparator<Integer[]>() {
        //     public int compare(Integer[] a, Integer[] b) {
        //         int x = 0;
        //         while (a[x] == b[x]) {
        //             x++;
        //             if (x == n) {
        //                 x = n - 1;
        //                 break;
        //             }
        //         }
        //         if (a[x] == b[x]) return a[n] - b[n];
        //         return a[x] - b[x];
        //     }
        // });

        // System.out.println();
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n + 1; j++) {
        //         System.out.print(pref.get(i)[j] + " ");
        //     }
        //     System.out.println();
        // }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            //System.out.println(Arrays.toString(taken));
            while (true) {
                if (!taken[pref.get(i)[j] - 1]) {
                    if (pref.get(i)[j] == i + 1) {
                        taken[pref.get(i)[j] - 1] = true;
                        ans[pref.get(i)[n]] = pref.get(i)[j];
                    } else {
                        int ind = ind(pref.get(pref.get(i)[j] - 1), pref.get(i)[j], taken);
                        if (!taken[pref.get(pref.get(i)[j])[ind - 1]]) {
                            taken[pref.get(i)[j] - 1] = true;
                            ans[pref.get(i)[n]] = pref.get(i)[j];
                        } else {
                            taken[pref.get(i)[n] - 1] = true;
                            ans[pref.get(i)[n] - 1] = pref.get(i)[n];
                        }
                    }
                    break;
                }
                j++;
                if (j == n) break;
            }
            //System.out.println(j);
        }
        for (int i = 0; i < n; i++) System.out.println(ans[i]);
    }

    public static int ind(Integer[] a, Integer p, boolean[] taken) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == p) return i;
        }
        return -1;
    }
}