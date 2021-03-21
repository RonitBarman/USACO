import java.io.*;
import java.util.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=241

public class relay {

    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("relay.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("relay.out")));
        int n = Integer.parseInt(in.readLine());
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(in.readLine());
            if (temp != 0) adj[i].add(temp-1);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            if (dfs(i, visited)) count++;
        }
        System.out.println(n-count);
        out.println(n-count);
        out.close();

    }

    static boolean dfs(int node, boolean[] visited) {
        if (visited[node]) return true;
        visited[node] = true;
        for (int i : adj[node]) {
            if (dfs(i, visited)) return true;
        }
        return false;
    }
}