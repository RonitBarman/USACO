import java.io.*;
import java.util.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=788

public class mootube {

    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static boolean[] visited2;
    static boolean[] visited3;
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("mootube.in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        int x1 = 0;
        int x2 = 0;
        int w = 0;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(in.readLine());
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[x1-1].add(new Node(x2, w));
            adj[x2-1].add(new Node(x1, w));
        
        }
        
        int[] ans = new int[q];
        int ki = 0;
        int vi = 0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(in.readLine());
            ki = Integer.parseInt(st.nextToken());
            vi = Integer.parseInt(st.nextToken());
            visited = new boolean[n];
            ans[i] = dfs(ki, vi);
        }
        for (int i = 0; i < q; i++) {
            System.out.println(ans[i]+" ANS");
            //if (ans[i] == 1) out.println(0);
            //else out.println(ans[i]);
        }
        //out.close();
        visited2 = new boolean[adj.length];
        min = Integer.MAX_VALUE;
        System.out.println(relevence(1, 2)+" R");

        visited2 = new boolean[adj.length];
        min = Integer.MAX_VALUE;
        System.out.println(relevence(1, 4)+" R");
    }


    static class Node {
        public int n;
        public int w;

        public Node(int n, int w) {
            this.w = w;
            this.n = n;
        }
    }
    
    static int dfs(int k, int node) {
        int count = 1;
        visited[node-1] = true;
        for (Node n : adj[node-1]) {
            visited2 = new boolean[adj.length];
            //System.out.println(relevence(node, n.n)+" N");
            min = Integer.MAX_VALUE;
            if (!visited[n.n-1] && (relevence(node, n.n) >= k)) {
                System.out.println(node + " " +n.n+" N");
                count += dfs(k, n.n);
            }
        }
        return count;
    }
    static int min = Integer.MAX_VALUE;
    static int pmin = Integer.MAX_VALUE;
    static int relevence(int n1, int n2) {
        visited2[n1-1] = true;
        for (Node n : adj[n1-1]) {
    
            if (!visited2[n.n-1] /*&& n.n != n2*/) {
                //min = Math.min(min, n.w);
                if (n.n == n2) {
                    min = Math.min(min, n.w);
                    break;
                }
                else relevence(n.n, n2);
            } 
            /*else {
                min = Math.min(min, n.w);
                break;
            }*/
        }
        return min;
    }
    static boolean contains(int node, int i) {
        for (Node n: adj[node-1]) if (n.n == i) return true;
        return false;
    }

    
}