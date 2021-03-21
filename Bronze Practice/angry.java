import java.util.*;
import java.io.*;

public class angry {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("angry.in")));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

        int n = Integer.parseInt(in.readLine());
        int[] bales = new int[n];
        for (int i = 0; i < n; i++) bales[i] = Integer.parseInt(in.readLine());
        Arrays.sort(bales);
        System.out.println("________________");
        int count = 1; 
        int maxCount = -1;
        for (int i = 0; i < n; i++) {
            boolean done = false;
            int r = 1;
            int b = i;
            int c = 0;
            while (!done) {
                for (int j = b-1; j >= 0; j--) {
                    if (bales[b]-bales[j] <= r) {
                        count++;
                        c++;
                        if (j == 0) done = true;
                    } else {
                        b = j+1;
                        r++;
                        break;
                    }
                }
                if (c == 0) done = true;
                c = 0;
            }
            System.out.println(count+"c");
            done = false;
            c = 0;
            r = 1;
            b = i;
            while (!done) {
                for (int j = b+1; j < n; j++) {
                    if (bales[j]-bales[b] <= r) {
                        count++;
                        c++;
                        if (j == n-1) done = true;
                    } else {
                        b = j-1;
                        r++;
                        break;
                    }
                }
                if (c == 0) done = true;
                c = 0;
            }
            System.out.println(count + "c" +" "+bales[i]);
            System.out.print("------------\n");
            maxCount = (count > maxCount) ? count:maxCount;
            count = 1;
        }
        System.out.println(maxCount);
        out.println(maxCount);
        out.close();
    }


}
