import java.util.*;
import java.io.*;


public class p2 {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        
        int n = scanner.nextInt();
        String[] dir = new String[n];
        int[][] place = new int[n][2];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            dir[i] = scanner.next();
            place[i][0] = scanner.nextInt();
            place[i][1] = scanner.nextInt();
        }

        int[][] land = new int[1_000][1_000];
        

        boolean[] stopped = new boolean[n];

        for (int i = 0; i < 950; i++) {
            for (int j = 0; j < n; j++) {
                if (!stopped[j]) {

                    land[place[j][1]][place[j][0]] = 1;

                    count[j]++;
                    if (dir[j].equals("N")) {
                        if (land[place[j][1]+1][place[j][0]] == 0) {
                            place[j][1]++;
                            
                        } else {
                            stopped[j] = true;
                        }
                    } else {
                        if (land[place[j][1]]
                        [place[j][0]+1] == 0) {
                            place[j][0]++;
                        } else {
                            stopped[j] = true;
                        }
                    }
                }
            }
        }
        // System.out.println(land[6][11]);
        // stopped[0] = true;
        // count[0] = 5;
        for (int i = 0; i < n; i++) {
            if (stopped[i] == true) System.out.println(count[i]);
            else System.out.println("Infinity");
        }

        
        
    }


}