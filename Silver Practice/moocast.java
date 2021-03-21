import java.io.*;
import java.util.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=668

public class moocast {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("moocast.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));

        int n = Integer.parseInt(in.readLine());
        int[][] cows = new int[n][3];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
            cows[i][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (dist(cows[i][0], cows[i][1], cows[j][0], cows[j][1]) <= cows[i][2]) adj[i].add(j);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            max = Math.max(max, dfs(i));
            //System.out.println(i+" "+max);
        }
        System.out.println(max);
        out.println(max);
        out.close();
    }

    static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(Math.abs(y1-y2), 2) + Math.pow(Math.abs(x1-x2), 2));
    }

    static int dfs(int node) {
        int count = 1;
        visited[node] = true;
        for (int i : adj[node]) {
            if (!visited[i]) count += dfs(i);
        }
        return count;
    }
}