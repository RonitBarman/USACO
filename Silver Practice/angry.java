import java.io.*;
import java.util.*;

public class angry {
    static ArrayList<Integer> pos;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        pos = new ArrayList<>();
        for (int i = 0; i < n; i++) pos.add(Integer.parseInt(in.readLine()));
        in.close();

        Collections.sort(pos);
        int high = 1_000_000_001;
        int low = 0;
        while (low < high) {
            high++;
            int mid = low + (high - low - 1)/2;
            if (simulate(mid)) high = mid;
            else low = mid + 1;
        }
        System.out.println(low);
        out.println(low);
        out.close();
    }
    
    static boolean simulate(int r) {
        int ind = 0;
        ArrayList<Integer> rem = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int j = ind;
            while (pos.get(j) <= pos.get(ind) + 2*r) {
                rem.add(j);
                j++;
                if (j >= pos.size()) break;
            }
            if (j >= pos.size()) break;
            ind = j;
        }
        return rem.size() == pos.size();
    }
}
