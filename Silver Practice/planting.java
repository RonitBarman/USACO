import java.io.*;
import java.util.*;

public class planting {

    static int n;
    static Node[] nodes;
    static ArrayList<Node>[] adj;
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader("planting.in"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        adj = new ArrayList[n];
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {adj[i] = new ArrayList<>(); nodes[i] = new Node(i, 0);}

        
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a - 1].add(new Node(b - 1, 0));
            adj[b - 1].add(new Node(a - 1, 0));
        }
        for (int i = 0; i < n; i++) {
            dfs(i);
        }

        System.out.println(max);
        for (Node no : nodes) System.out.println(no.i + " " +no.v);
        // out.println(max);
        // out.close();

    }
    static int max = -1;
    static void dfs(int node) {
        for (Node no : adj[node]) {
            if (no.v == nodes[node].v || check(no.i)) {
                if (no.v >= n/2) no.v--;
                else no.v++; 
                nodes[no.i].v = no.v;
                dfs(no.i); 
                max = Math.max(max, no.v);
            }
        }
    }
    static boolean check(int i) {
        HashSet<Integer> set = new HashSet<>();
        for (Node n : adj[i]) {
            set.add(n.v);
        }
        return adj[i].size() == set.size();
    }
    static class Node {
        int v, i;
        Node(int i, int v) { this.v = v; this.i = i; }
    }
}