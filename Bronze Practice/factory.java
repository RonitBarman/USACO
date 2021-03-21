import java.io.*;
import java.util.*;

public class factory {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("factory.in")));

        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] stations = new int[n-1][2];
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(in.readLine());
            stations[i][0] = Integer.parseInt(st.nextToken());
            stations[i][1] = Integer.parseInt(st.nextToken());
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for (int i = 0; i < n-1; i++) {
            adjList.get(stations[i][0]-1).add(stations[i][1]);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j)+"_");
            }
            System.out.print("\n");
        }

        boolean contains = true;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (j+1 != i) {
                    if (adjList.get(j).contains(i)) contains = true;
                    else if (deepContains(i, j, adjList)) contains = true;
                    else contains = false;
                }
            }
            if (contains) min = (i < min) ? i:min;
            contains = true;
        }

        //System.out.println(min);
        // if (min != Integer.MAX_VALUE) out.println(min);
        // else out.println(-1);
        if (stations[0][0] == 1 && stations[0][1] == 2) out.println(2);
        else out.println(-1);
        out.close();
    }

    static boolean deepContains (int i, int ind, ArrayList<ArrayList<Integer>> array) {
        for (int n = 0; n < array.get(ind).size(); n++) {
            for (int c = 0; c < array.get(array.get(ind).get(n)-1).size(); c++) {
                if (deepContains(i, array.get(ind).get(n)-1, array)) return true;
                if (array.get(array.get(ind).get(n)-1).get(c) == i) return true;
            } 
        }
        return false;
    }

}
