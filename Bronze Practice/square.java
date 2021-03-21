import java.util.*;
import java.io.*;

public class square {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("square.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));

        Scanner scanner = new Scanner(in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();
        scanner.close();

        int len = 0;
        //int len = (Math.abs(y1-y4) > Math.abs(x2-x3)) ? Math.abs(y1-y4):Math.abs(x2-x3);

        //x1 > x3 && x1 < x4 && x2 > x3 && x2 < x4


        if (x1 > x3 && x2 < x4) {
            len = Math.max(Math.abs(y4-y1), Math.abs(x4-x3));
        } else if (x3 > x1 && x4 < x2) {
            len = Math.max(Math.abs(y4-y1), Math.abs(x2-x1));
        } else if (y1 > y3 && y2 < y4) {
            len = Math.max(Math.abs(x3-x2), Math.abs(y4-y3));
        } else if (y3 > y1 && y4 < y2) {
            len = Math.max(Math.abs(x3-x2), Math.abs(y2-y1));
        } else if ((y1 >= y3 && y2 >= y4)) {
            len = Math.max(Math.abs(y2-y3), Math.abs(x1-x4));
        } else if ((y3 >= y1 && y4 >= y2)) {
            len = (Math.abs(y1-y4) > Math.abs(x2-x3)) ? Math.abs(y1-y4):Math.abs(x2-x3);
        } else {
            len = (Math.abs(x1-x4) > Math.abs(y2-y3)) ? Math.abs(x1-x4):Math.abs(y2-y3);
        }


    
        out.println(len*len);
        out.close();

    }
    
}
