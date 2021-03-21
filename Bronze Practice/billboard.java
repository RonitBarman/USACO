import java.io.*;
import java.util.*;


import java.awt.*;

class billboard {
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader in = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
        
        Scanner scanner = new Scanner(in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int w1 = Math.abs(x1-x2);
        int h1 = Math.abs(y1-y2);

        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();
        int w2 = Math.abs(x3-x4);
        int h2 = Math.abs(y3-y4);
        scanner.close();
        in.close();
        
        Rectangle lawnMower = new Rectangle(x1, y2, w1, h1);
        Rectangle cowFeed = new Rectangle(x3, y4, w2, h2);                                 

        

        int tarp = 0;
        Rectangle intersection = intersection(x1, y1, x2, y2, x3, y3, x4, y4);
        System.out.println(intersection.x+" x"+ intersection.y+" y");
        if (!intersection.isEmpty()) {
            if (intersection.height == h1 || intersection.width == w1) {
                tarp = (lawnMower.width*lawnMower.height)-(intersection.width*intersection.height);
            } else {
                tarp = lawnMower.height*lawnMower.width;
            }
        } else {
            tarp = lawnMower.height*lawnMower.width;
        }

        System.out.println(tarp);
        out.println(tarp);
        out.close();

    }

    static Rectangle intersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int xMax = Math.max(x1, x3);
        int xMin = Math.min(x2, x4);
        int yMax = Math.max(y1, y3);
        int yMin = Math.min(y2, y4);
        return new Rectangle(xMax, yMin, Math.abs(xMin-xMax), Math.abs(yMin-yMax));
    }
}