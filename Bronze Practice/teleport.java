import java.util.*;
import java.io.*;


public class teleport {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("teleport.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("teleport.out"))));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int total = 0;
        if ((x == a && y == b) || (x == b && y == a)) total = 0;
        else if (x == a) total += Math.abs(y-b);
        else if (y == a) total += Math.abs(x-b);
        else if (Math.abs(x-a) < Math.abs(y-a)) {
            if (b-a < Math.abs(x-a) + Math.abs(y-b)) total += b-a;
            else total += Math.abs(x-a) + Math.abs(y-b);
        } else {
            if (b-a < Math.abs(y-a) + Math.abs(x-b)) total += b-a;
            else total += Math.abs(y-a) + Math.abs(x-b);
        }
        out.println(total);
        out.close();
    }
    
}
