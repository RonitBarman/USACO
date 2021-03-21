import java.io.*;
import java.util.*;

public class notlast {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("notlast.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        TreeMap<String, Integer> cows = new TreeMap<>();
        cows.put("Bessie", 0); cows.put("Elsie", 0); cows.put("Daisy", 0); cows.put("Annabelle", 0);
        cows.put("Maggie", 0); cows.put("Henrietta", 0); cows.put("Gertie", 0);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            int val = Integer.parseInt(st.nextToken());
            if (cows.containsKey(name)) {
                cows.replace(name, cows.get(name)+val);
            } else {
                cows.put(name, val);
            }
        }
        TreeSet<Integer> sorted = new TreeSet<>();
        for (int num : cows.values()) {
            sorted.add(num);
        }
        Object[] sorted2 = sorted.toArray();
        String sname = "";
        int c = 0;
        if (sorted2.length != 1) {
            for (Map.Entry<String, Integer> entry:cows.entrySet()) {
                if (entry.getValue().equals(sorted2[1])) {
                    sname = entry.getKey();
                    c++;
                }
            }
        }
        
        if (c == 1) System.out.println(sname);
        else System.out.println("Tie");
        
        if (c == 1) out.println(sname);
        else out.println("Tie");
        out.close();

    }
    
}
