import java.util.*;
import java.io.*;


public class reduce2 {
    static ArrayList<Cow> sortedHoriz;
    static ArrayList<Cow> sortedVert;
    static int n;
    static long minA;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("reduce.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        
        sortedHoriz = new ArrayList<>();
        sortedVert = new ArrayList<>();
        
        HashSet<Cow> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            hs.add(new Cow(a, b));
            sortedHoriz.add(new Cow(a, b));
            sortedVert.add(new Cow(a, b));
        }
        in.close();
        Collections.sort(sortedHoriz, new HComparator());
        Collections.sort(sortedVert, new VComparator());

        minA = (sortedVert.get(0).y - sortedVert.get(n-1).y)*(sortedHoriz.get(0).x - sortedHoriz.get(n-1).x);
        
        Cow t = removeCow();
        sortedHoriz.remove(t);
        sortedVert.remove(t);
        t = removeCow();
        sortedHoriz.remove(t);
        sortedVert.remove(t);
        t = removeCow();
        sortedHoriz.remove(t);
        sortedVert.remove(t);

        System.out.println((sortedVert.get(sortedVert.size()-1).y - sortedVert.get(0).y)*(sortedHoriz.get(sortedHoriz.size()-1).x - sortedHoriz.get(0).x));
        out.println((sortedVert.get(sortedVert.size()-1).y - sortedVert.get(0).y)*(sortedHoriz.get(sortedHoriz.size()-1).x - sortedHoriz.get(0).x));
        out.close();
    }
        

    static boolean isBorder(int x, int y, int smallx, int bigX, int smally, int bigY) {
        if (x == smallx || x == bigX || y == bigY || y == smally) return true;
        else return false;
    } 
    static class HComparator implements Comparator<Cow> {
        @Override
        public int compare(Cow a, Cow b) {
            return a.x-b.x;
        }
    }
    
    static class VComparator implements Comparator<Cow> {
        @Override
        public int compare(Cow a, Cow b) {
            return a.y- b.y;
        }
    }
    
    static class Cow {
        int x;
        int y;
        public Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            // null check
            if (o == null) return false;
            // type check and cast
            if (getClass() != o.getClass()) return false;
            Cow c = (Cow) o;
            return Objects.equals(x, c.x)
            && Objects.equals(y, c.y);
        }
    }
    static Cow removeCow() {
        Cow c = new Cow(0,0);
        for (int i = 0; i < sortedHoriz.size(); i++) {
            int bx = Integer.MIN_VALUE;
            int by = Integer.MIN_VALUE;
            int sx = Integer.MAX_VALUE;
            int sy = Integer.MAX_VALUE;
            if (isBorder(sortedHoriz.get(i).x, sortedHoriz.get(i).y, sortedHoriz.get(0).x, sortedHoriz.get(sortedHoriz.size()-1).x, 
            sortedVert.get(0).y, sortedVert.get(sortedVert.size()-1).y)) {

                for (int j = 0; j < sortedHoriz.size(); j++) {
                    if (i != j) {
                        bx = Math.max(sortedHoriz.get(j).x, bx);
                        by = Math.max(sortedHoriz.get(j).y, by);
                        sx = Math.min(sortedHoriz.get(j).x, sx);
                        sy = Math.min(sortedHoriz.get(j).y, sy);
                    }
                }
                if (((by-sy)*(bx-sx)) < minA) {
                    minA = ((by-sy)*(bx-sx));
                    c.x = sortedHoriz.get(i).x;
                    c.y = sortedHoriz.get(i).y;
                }
            }
        }
        return c;
    }
}

    






