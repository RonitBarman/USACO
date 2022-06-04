import java.io.*;
import java.util.*;

public class milkvisits {

    static int n;
    static int m;
    static boolean[] visited;
    static char[] type;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        type = in.readLine().toCharArray();
        visited = new boolean[n];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(in.readLine());
            adj[Integer.parseInt(st.nextToken())-1].add(Integer.parseInt(st.nextToken())-1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) dfs(i, j);
            }
        }
        String res = "";
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int b = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            char t = st.nextToken().charAt(0);
            if (dfs(b, e, t)) res += "1";
            else res += "0";
            visited = new boolean[n];
        }
        System.out.println(res);
        visited = new boolean[n];
    }
    static boolean dfs(int b, int e, char t) {
        for (int i : adj[b]) {
            if (type[i] == t) return true;
            else if (dfs(i, e)) dfs(i, e, t);
            
            
        }
        return false;
    }
    
    static boolean dfs(int b, int e) {
        visited[b] = true;
        if (b == e) return true;
        for (int i : adj[b]) {
            if (!visited[i]) {
                System.out.println(i);
                if (i == e) return true;
                if (i > b) dfs(i, e);
            }
        }
        return false;
    }
}