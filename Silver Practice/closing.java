import java.io.*;
import java.util.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=644

public class closing {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean[] removed;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("closing.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adj[n1-1].add(n2-1);
            adj[n2-1].add(n1-1);
        }

        for (int i = -1; i < n-1; i++) {
            if (i == -1) {
                removed = new boolean[n];
                if (dfs(0) == n) {
                    //System.out.println("YES");
                    out.println("YES");
                } else {
                    //System.out.println("NO");
                    out.println("NO");
                }
            } else {
                removed[Integer.parseInt(in.readLine())-1] = true;
                
                for (int d = 0; d < n; d++) {
                    if (!removed[d]) {
                        visited = new boolean[n];
                        if (dfs(d) == n-(i+1)) {
                            //System.out.println("YES");
                            out.println("YES");
                        } else {
                            //System.out.println("NO");
                            out.println("NO");
                        }
                        break;
                    }
                }
            }
        }
        out.close();
    }

    static int dfs(int node) {
        int count = 1;
        visited[node] = true;
        for (int i : adj[node]) {
            if (!removed[i]) if (!visited[i]) count += dfs(i);
        }
        return count;
    }
}