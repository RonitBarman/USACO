import java.util.*;
import java.io.*;


public class promote {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("promote.in"));
        Scanner scanner = new Scanner(in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));

        int[][] contest = new int[4][2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                contest[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        out.println((contest[2][1]+contest[3][1]+contest[1][1]) - (contest[2][0]+contest[3][0]+contest[1][0]));

        out.println((contest[2][1]+contest[3][1]) - (contest[2][0]+contest[3][0]));
        
        out.println(contest[3][1] - contest[3][0]);
        out.close();

    }
}
