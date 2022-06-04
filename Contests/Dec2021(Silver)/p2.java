import java.io.*;
import java.util.*;

public class p2 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int cost = 0;
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("p2.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("p2.out")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adj = new ArrayList[n];
            visited = new boolean[n];
            for (int r = 0; r < n; r++) adj[r] = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                adj[a].add(b);
                adj[b].add(a);
            }
            dfs(0, n - 1);
            System.out.println(cost);
            cost = 0;
        }
        
    }
    static void dfs(int node, int n) {
        visited[node] = true;
        if (!adj[node].isEmpty()) {
            for (int i : adj[node]) {
                if (i == n) return;
                if (!visited[i]) dfs(i, n);
            }
        } else {
            adj[node].add(node + 1);
            cost++;
            dfs(node + 1, n);
        }
    }
}