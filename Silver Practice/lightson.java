import java.io.*;
import java.util.*;
// http://www.usaco.org/index.php?page=viewproblem2&cpid=570
public class lightson {

    static ArrayList<Integer>[] adj;
    static boolean[][] visited;
    static int n;
    static HashSet<Switch> lights;
    
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("lightson.in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lights = new HashSet<>();
        visited = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            String[] temp = in.readLine().split(" ");    
            Pair t1 = new Pair(Integer.parseInt(temp[0])-1, Integer.parseInt(temp[1])-1);      
            Pair t2 = new Pair(Integer.parseInt(temp[2])-1, Integer.parseInt(temp[3])-1);
            lights.add(new Switch(t1, t2));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            System.out.println(i+" i");
            max = Math.max(floodfill(0, 0), max);
        }
        System.out.println(max);
    }
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Switch {
        Pair p;
        Pair q;
        public Switch(Pair p, Pair q) {
            this.q = q;
            this.p = p;
        }
    }
    static int[] addi = {1, 0, -1, 0};
    static int[] addj = {0, 1, 0, -1};

    static int floodfill(int i, int j) {
        Stack<Pair> points = new Stack<>();
        int sum = 0;
        points.push(new Pair(i, j));
        System.out.println("HERE");
        while (!points.isEmpty()) {
            System.out.println("Herer");
            Pair temp = points.pop();
            i = temp.x; 
            j = temp.y;
            //if (i >= n || i < 0 || j >= n || j < 0 || visited[i][j]) continue;
            sum++;
            System.out.println(sum+" Sum");
            int c = 0;
            for (int t = 0; t < 4; t++) {
                int i2 = i + addi[t];
                int j2 = j + addj[t];
                Switch sw = new Switch(new Pair(i, j), new Pair(i2, j2));
                if (lights.contains(sw)) {
                    c++;
                    points.push(new Pair(i2, j2));
                }
            }
            if (c==0) {
                visited[i][j] = true;   
                return sum;
            }
        }
        return sum;
    }
}