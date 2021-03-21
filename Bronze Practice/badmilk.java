import java.util.*;
import java.awt.Rectangle;
import java.io.*;

import java.lang.*;
public class badmilk {
    public static void main(String[] args) throws Exception {
        // BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\contaminatedmilk\\in.txt"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\contaminatedmilk\\out.txt")));
        Rectangle rect = new Rectangle(0, 1, -1, -1);
        BufferedReader in = new BufferedReader(new FileReader("badmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] timeline = new int[Integer.parseInt(st.nextToken())][3];
        int sickLen = Integer.parseInt(st.nextToken());

        for (int i = 0; i < timeline.length; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < timeline[0].length; j++) {
                timeline[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // for (int i = 0; i < timeline.length; i++) {
        //     for (int j = 0; j < timeline[0].length; j++) {
        //         System.out.print(timeline[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        Map<Integer, Integer> sickPep = new TreeMap<>();

        for (int i = 0; i < sickLen; i++) {
            st = new StringTokenizer(in.readLine());
            // for (int j = 0; j < sick[0].length; j++) {
                // sick[i][j] = Integer.parseInt(st.nextToken());
                sickPep.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            // }
        }
        in.close();

        // Map<Integer, Integer> sickPep = new TreeMap<>();
        // for (int i = 0; i < sick.length; i++) {
        //     sickPep.put(sick[i][0], sick[i][1]);
        // }
        
        ArrayList<Set<Integer>> badmilks = new ArrayList<>();
        for (int i : sickPep.keySet()) badmilks.add(new HashSet<>());
        
        int[][] temp = new int[m][badmilks.size()];
        for (int i = 0; i < timeline.length; i++) {
            for (int time : sickPep.keySet()) {
                if (timeline[i][2] <= time || sickPep.containsKey(timeline[i][0])) {
                    // badmilks.get(timeline[i][0]-1).add(timeline[i][1]);
                    temp[timeline[i][1]-1][timeline[i][0]-1] = timeline[i][1]-1;
                }
            }
        }
        // int[][] temp = new int[m][badmilks.size()];
        // for (int i = 0; i < badmilks.size(); i++) {
        //     for (int j : badmilks.get(i)) {
        //         temp[j-1][i] = j;
        //     }
            
        // }_____________________________


        // for (int i = 0; i < temp.length; i++) System.out.print(temp[i][0]+" ");
        // System.out.println();
        // for (int i = 0; i < temp.length; i++) System.out.print(temp[i][1]+" ");


        int count = 0;
        Set<Integer> common = new HashSet<>();
        int sum = 0;
        int num = 0;

        for (int i = 0; i < temp.length; i++) {
            num = temp[i][0];
            for (int k = 0; k < temp[i].length; k++) {
                sum += temp[i][k];
            }
            if (sum != 0 && ((double) sum/badmilks.size()) == (double) num) common.add(num);
            sum = 0;
        }

        int maxCount = 0;
        for (int i : common) {
            for (int j = 0; j < timeline.length; j++) {
                if (timeline[j][1] == i) count++;
            }
            maxCount = (count > maxCount) ? count:maxCount;
            count = 0;
        }
        // System.out.println(maxCount);
        out.println(maxCount);
        out.close();

    }

    // static boolean isPartial(ArrayList<Integer> ar1, int num) {
    //     for (int i = 0; i < ar1.size(); i++) {
    //         if ()
    //     }
    // }

    
}