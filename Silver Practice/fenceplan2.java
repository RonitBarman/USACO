import java.io.*;
import java.util.*;

public class fenceplan2 {
    static int n;
    static Pair[] points;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("fenceplan.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        points = new Pair[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            points[i] = new Pair(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a-1].add(b-1);
            adj[b-1].add(a-1);
        }
        int minP = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            //System.out.print((i+1)+" ");
            for (int j : adj[i]) System.out.print((j+1)+" ");
            //System.out.print("\n");
        }
        for (int i = 0; i < n; i++) {
            max = -1;
            mix = Integer.MAX_VALUE;
            may = -1;
            miy = Integer.MAX_VALUE;
            if (!visited[i]) {
                Pair[] temp = dfs(i);
                //System.out.println(i+" i");
                //System.out.println((temp[0].x - temp[1].x + temp[0].y - temp[1].y)*2+" P");
                minP = Math.min(minP, (temp[0].x - temp[1].x + temp[0].y - temp[1].y)*2);
            }
        }
        System.out.println(minP);
        out.println(minP);
        out.close();
    }

    static int max = -1;
    static int mix = Integer.MAX_VALUE;
    static int may = -1;
    static int miy = Integer.MAX_VALUE;

    static Pair[] dfs(int c) {
        visited[c] = true;
        max = Math.max(max, points[c].x);
        mix = Math.min(mix, points[c].x);
        may = Math.max(may, points[c].y);
        miy = Math.min(miy, points[c].y);
        for (int i : adj[c]) {
            if (!visited[i]) {
                max = Math.max(max, points[i].x);
                mix = Math.min(mix, points[i].x);
                may = Math.max(may, points[i].y);
                miy = Math.min(miy, points[i].y);
                dfs(i);
            }
        }
        Pair[] temp = {new Pair(max, may), new Pair(mix,miy)};
        //System.out.println(temp[0].x+" "+temp[0].y+"   "+temp[1].x+" "+temp[1].y);
        return temp;
    }

    static class Pair {
        int x,y;
        Pair(int x, int y) { this.x = x; this.y = y; }
    }
}