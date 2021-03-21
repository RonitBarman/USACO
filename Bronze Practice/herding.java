import java.io.*;
import java.util.*;


public class herding {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("herding.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] cows = new int[3];

        cows[0] = Integer.parseInt(st.nextToken());
        cows[1] = Integer.parseInt(st.nextToken());
        cows[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(cows);
        int min = 0;
        if (cows[2] == cows[0]+2) min = 0;
        else if (cows[1] == cows[0]+2 || cows[2] == cows[1]+2) min = 1;
        else min = 2;

        System.out.println(min);
        System.out.println(Math.max(cows[2]-cows[1], cows[1]-cows[0])-1);

        out.println(min);
        out.println(Math.max(cows[2]-cows[1], cows[1]-cows[0])-1);    
        out.close();



    }
}
