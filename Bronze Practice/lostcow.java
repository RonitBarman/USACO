import java.util.*;


import java.io.*;

public class lostcow {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("lostcow.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int loc = 0;
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int c = 1;
        int x2 = x;
        boolean diff = x > y;
        while (true) {
            if (diff) {
                if (x + c <= y) {
                    loc += Math.abs(y - x2);
                    break;
                } 
                loc += x + c - x2;
                System.out.println(loc);
                x2 = x + c;
                c *= 2;
                if (x - c <= y) {
                    loc += Math.abs(y - x2);
                    break;
                }
                loc += Math.abs(x - c - x2);
                System.out.println(loc);
                x2 = x - c;
                c *= 2;
            } else {
                if (x + c >= y) {
                    loc += y - x2;
                    break;
                } 
                loc += x + c - x2;
                System.out.println(loc);
                x2 = x + c;
                c *= 2;
                if (x - c >= y) {
                    loc += y - x2;
                    break;
                }
                loc += Math.abs(x - c - x2);
                System.out.println(loc);
                x2 = x - c;
                c *= 2;
            }
        }
        System.out.println(loc);
        out.println(loc);
        out.close();

    }
}