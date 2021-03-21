import java.io.*;
import java.util.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=835

public class lemonade {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("lemonade.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        int n = Integer.parseInt(in.readLine());
        int[] waits = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) waits[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(waits);
        ArrayList<Integer> line = new ArrayList<>();
        int max = -1;
        for (int i = n-1; i >= 0; i--) {
            if (line.isEmpty()) line.add(waits[i]);
            else if (waits[i] >= line.size()) line.add(waits[i]);
            max = Math.max(max, line.size());
        }
        System.out.println(max);
        out.println(max);
        out.close();
    }
}