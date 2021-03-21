import java.util.*;
import java.io.*;
//import java.awt.*;
//import java.awt.geom.Rectangle2D;

public class reduce {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("reduce.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        int[] y = new int[n];
        int bigX = Integer.MIN_VALUE;
        int bigY = Integer.MIN_VALUE;
        int smallx = Integer.MAX_VALUE;
        int smally = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            bigX = (x[i] > bigX) ? x[i]:bigX;
            bigY = (y[i] > bigY) ? y[i]:bigY;
            smallx = (x[i] < smallx) ? x[i]:smallx;
            smally = (y[i] < smally) ? y[i]:smally;
        }
        
        int minA = (bigY-smally)*(bigX-smallx);
        
        int bX = Integer.MIN_VALUE;
        int bY = Integer.MIN_VALUE;
        int sx = Integer.MAX_VALUE;
        int sy = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (isBorder(x[i], y[i], smallx, bigX, smally, bigY)) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        bX = (x[j] > bX) ? x[j]:bX;
                        bY = (y[j] > bY) ? y[j]:bY;
                        sx = (x[j] < sx) ? x[j]:sx;
                        sy = (y[j] < sy) ? y[j]:sy;
                    }
                }
                //System.out.println(bX+" "+bY + "  " + sx+" "+sy);
                if (((bY-sy)*(bX-sx)) < minA) minA = ((bY-sy)*(bX-sx));
                bX = Integer.MIN_VALUE;
                bY = Integer.MIN_VALUE;
                sx = Integer.MAX_VALUE;
                sy = Integer.MAX_VALUE;
            }
        }
        //System.out.println(minA+"F");
        out.println(minA);
        out.close();

    }

    static boolean isBorder(int x, int y, int smallx, int bigX, int smally, int bigY) {
        if (x == smallx || x == bigX || y == bigY || y == smally) return true;
        else return false;
    } 


    // static int intersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4,  int y4) {
    //     int rvalue = 0;
    //     if (y1 > y3 && y2 < y4) {
    //         if (x1 < x2) {  

    //         }
    //     } else if (y3 > y1 && y4 < y2) {

    //     } else if (y3 > y1) {
    //         if (x3 > x1) {
    //             rvalue = (y2-y3)*(x2-x3);
    //         } else {
    //             rvalue = (y2-y3)*(x4-x1);
    //         }
    //     } else if (y1 > y3) {
    //         if (x1 < x3) {
    //             rvalue = (y4-y1)*(x2-x3);
    //         } else {
    //             rvalue = (y4-y1)*(x4-x1);
    //         }
    //     }
    //     return 0;
        
    // }

    static boolean intersects(int x1, int y1, int x2, int y2, int x3, int y3, int x4,  int y4) {
        if ((x1 < x3 && x3 < x2) && (y1 < y3 && y3 < y2)) return true;
        else if ((x1 < x4 && x4 < x2) && (y1 < y3 && y3 < y2));
        return false;
    }

    // static Rectangle intersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4,  int y4) {
        
    // }
}
// Rectangle rect = new Rectangle(14, 11, 3, 3);
// Rectangle rect2 = new Rectangle(13, 13, 3, 4);
// Rectangle inter = rect2.intersection(rect);
// inter.x -= 1;
// inter.height -= 1;
// System.out.println("X "+inter.getX());
// System.out.println("Y "+inter.getY());
// System.out.println("W "+inter.getWidth());
// System.out.println("H "+inter.getHeight());


