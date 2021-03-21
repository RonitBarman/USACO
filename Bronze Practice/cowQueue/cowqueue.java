import java.io.*;
import java.util.*;


public class cowqueue {
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(new File("C:\\Users\\ronit\\RandomJava\\USACO\\cowQueue\\in.txt"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\cowQueue\\out.txt")));

        Scanner scanner = new Scanner(new File("cowqueue.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));

        int n = scanner.nextInt();
        
        TreeMap<Integer, Integer> timeline = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            timeline.put(scanner.nextInt(), scanner.nextInt());
        }
        scanner.close();
        int totaltime = 0;
        int i = 0;
        int prevP = 0;
        int prevT = 0;
        for (Map.Entry<Integer, Integer> entry : timeline.entrySet()) {
            if (i == 0) totaltime += entry.getKey()+entry.getValue();
            else if (entry.getKey() > totaltime) {
                totaltime += entry.getKey()-totaltime+entry.getValue();
            } else totaltime += entry.getValue();
            prevT = entry.getKey();
            prevP = entry.getValue();
            i++;
        }

        out.println(totaltime);
        out.close();
        System.out.println(totaltime);
    }
    
}
