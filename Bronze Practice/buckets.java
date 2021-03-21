import java.util.*;
import java.io.*;

/**
 * buckets
 */
public class buckets {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("buckets.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));

        String[][] map = new String[10][10];
        for (int i = 0; i < 10; i++) map[i] = in.readLine().split("");

        int[] bloc = new int[2];
        int[] lloc = new int[2];
        int[] rloc = new int[2];
        for (int i = 0; i < 10; i++) for (int j = 0; j < 10; j++) {
            if (map[i][j].equals("B")) {
                bloc[0] = i;
                bloc[1] = j;
            }
            if (map[i][j].equals("L")) {
                lloc[0] = i;
                lloc[1] = j;
            }
            if (map[i][j].equals("R")) {
                rloc[0] = i;
                rloc[1] = j;
            }
        }
        
        if (bloc[0] == lloc[0] && rloc[0] == bloc[0]) {
            if (bloc[1] < lloc[1]) {
                if (rloc[1] >= bloc[1] && rloc[1] <= lloc[1]) {
                    out.println(Math.abs(rloc[1]-bloc[1]) + 3 + Math.abs(rloc[1]-lloc[1]) - 2);
                } else {
                    out.println(Math.abs(bloc[1]-lloc[1])-1);
                }
            } else if (bloc[1] > lloc[1]) {
                if (rloc[1] <= bloc[1] && rloc[1] >= lloc[1]) {
                    out.println(Math.abs(rloc[1]-bloc[1]) + 3 + Math.abs(rloc[1]-lloc[1]) - 2);
                } else {
                    out.println(Math.abs(bloc[1]-lloc[1])-1);
                }
            }
            //out.println(Math.abs(rloc[0]-bloc[0]) + 3 + Math.abs(rloc[0]-lloc[0]));
        } else if (bloc[1] == lloc[1] && rloc[1] == bloc[1]) {
            if (bloc[0] < lloc[0]) {
                if (rloc[0] >= bloc[0] && rloc[0] <= lloc[0]) {
                    out.println(Math.abs(rloc[0]-bloc[0]) + 3 + Math.abs(rloc[0]-lloc[0]) - 2);
                } else {
                    out.println(Math.abs(bloc[0]-lloc[0])-1);
                }
            } else if (bloc[0] > lloc[0]) {
                if (rloc[0] <= bloc[0] && rloc[0] >= lloc[0]) {
                    out.println(Math.abs(rloc[0]-bloc[0]) + 3 + Math.abs(rloc[0]-lloc[0]) - 2);
                } else {
                    out.println(Math.abs(bloc[0]-lloc[0])-1);
                }
            }
            //out.println(Math.abs(rloc[1]-bloc[1]) + 3 + Math.abs(rloc[1]-lloc[1]));
        } else if (bloc[0] == lloc[0]) {
            out.println(Math.abs(bloc[1]-lloc[1])-1);
        } else if(bloc[1] == lloc[1]) {
            out.println(Math.abs(bloc[0]-lloc[0])-1);
        } else {
            out.print(Math.abs(bloc[0]-lloc[0]) + Math.abs(bloc[1]-lloc[1])-1);
        }
        out.close();
    }
}