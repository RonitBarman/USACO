import java.io.*;
import java.util.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=944
public class fenceplan {
    
    static ArrayList<Point> adj[];
    static Point[] points;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("fenceplan.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out"))); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        visited = new boolean[n];
        Point temp = new Point(0,0,0);
        points = new Point[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine()); 
            temp = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
            points[i] = temp;
            adj[i].add(temp);
        }
        int n1 = 0; 
        int n2 = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine()); 
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            adj[n1-1].add(points[n2-1]);
            adj[n2-1].add(points[n1-1]);
        }

        int minP = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minX = Integer.MAX_VALUE;
            maxX = Integer.MIN_VALUE;
            minY = Integer.MAX_VALUE;
            maxY = Integer.MIN_VALUE;
            //visited = new boolean[n];
            minX = Math.min(points[i].x, minX);
            maxX = Math.max(points[i].x, maxX);
            minY = Math.min(points[i].y, minY);
            maxY = Math.max(points[i].y, maxY);
            minP = Math.min(minP, dfs(i));
            //System.out.println("  "+points[i].x+" "+points[i].y+" C"+" "+minP);
        }
        //System.out.println(minP);
        out.println(minP);
        out.close();
    }

    static class Point {
        int x;
        int y;
        int n;
        public Point(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }

    
    static int minX = Integer.MAX_VALUE;
    static int maxX = Integer.MIN_VALUE;
    static int minY = Integer.MAX_VALUE;
    static int maxY = Integer.MIN_VALUE;
    static int dfs(int node) {
        visited[node] = true;
        for (Point p : adj[node]) {
            if (!visited[p.n]) {
                minX = Math.min(p.x, minX);
                maxX = Math.max(p.x, maxX);
                minY = Math.min(p.y, minY);
                maxY = Math.max(p.y, maxY);
                dfs(p.n);
            }
        }
        //System.out.println(maxX+" "+maxY+"   "+minX+" "+minY+" P");
        if (Math.abs(maxX-minX)==0 && Math.abs(maxY-minY)==0) return Integer.MAX_VALUE;
        if (Math.abs(maxX-minX)==0) return Math.abs(maxY-minY);
        else if (Math.abs(maxY-minY)==0) return Math.abs(maxX-minX);
        else return 2*(Math.abs(maxX-minX)) + 2*(Math.abs(maxY-minY));
    }
}
// visited[i] = true;
// minX = Math.min(points[i].x, minX);
// maxX = Math.max(points[i].x, maxX);
// minY = Math.min(points[i].y, minY);
// maxY = Math.min(points[i].y, maxY);
// for (Point p : adj[i]) {
//     if (!visited[p.n]) {
//         minX = Math.min(p.x, minX);
//         maxX = Math.max(p.x, maxX);
//         minY = Math.min(p.y, minY);
//         maxY = Math.max(p.y, maxY);
//         visited[p.n] = true;
//     }
// }

// System.out.println(maxX+" "+minX+"   "+maxY+" "+minY);
// System.out.println(2*(Math.abs(maxX-minX)) +" "+ 2*(Math.abs(maxY-minY))+" P");
// if (2*(Math.abs(maxX-minX)) + 2*(Math.abs(maxY-minY)) > 0) minP = Math.min(2*(Math.abs(maxX-minX)) + 2*(Math.abs(maxY-minY)), minP);
// System.out.println(minP);