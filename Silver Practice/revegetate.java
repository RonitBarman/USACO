import java.io.*;
import java.util.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=920

public class revegetate {

    static ArrayList<Integer>[] adjs = new ArrayList[100001];
    static ArrayList<Integer>[] adjd = new ArrayList[100001];
    static boolean[] visited;
    static int[] labels = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("revegetate.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());

        for (int i = 0; i < 100001; i++) {
            adjs[i] = new ArrayList<>();
            adjd[i] = new ArrayList<>();
        }

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            String temp = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            if (temp.equals("S")) {
                adjs[p].add(q);
                adjs[q].add(p);
            } 
            if (temp.equals("D")) {
                adjd[p].add(q);
                adjd[q].add(p);
            }
        }
        impossible = false;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (labels[i] == 0) {
                dfs(i, 1);
                count++;
            }
        }
        long ans = (long) Math.pow(2, count);
        System.out.println(ans);
        if (impossible) {
            System.out.println(0);
            out.println(0);
        } else {
            System.out.println(Long.toBinaryString(ans));
            out.print(1);
            for (int i = 0; i < count; i++) out.print(0);
            out.print("\n");
        }
        out.close();
    }
    static boolean impossible;
    static void dfs(int x, int v) {
        labels[x] = v;
        for (int i : adjs[x]) {
            if (labels[i] == 3-v) impossible = true;
            if (labels[i] == 0) dfs(i, v);
        }
        for (int i : adjd[x]) {
            if (labels[i] == v) impossible = true;
            if (labels[i] == 0) dfs(i, 3-v);
        }
    }
}