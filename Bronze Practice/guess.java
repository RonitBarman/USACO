import java.io.*;
import java.util.*;


public class guess {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("guess.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        TreeMap<String, ArrayList<String>> animals = new TreeMap<>();
        String name = "";
        String cha = "";
        HashSet<String> feats = new HashSet<>();
        int k = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            name = st.nextToken();
            animals.put(name, new ArrayList<>());
            k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                cha = st.nextToken();
                feats.add(cha);
                animals.get(name).add(cha);
            }
        }
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (String str:animals.keySet()) {
            for (String stri:animals.keySet()) {
                if (!str.equals(stri)) {
                    for (String feat:animals.get(stri)) {
                        for (String feat2:animals.get(str)) {
                            if (feat.equals(feat2)) count++;
                        }
                    }
                }
                max = (count > max) ? count:max;
                count = 0;
            }
        }
        

        // Set<String> pot = new HashSet<>();
        // Set<String> rem = new HashSet<>();
        // HashSet<String> fcopy = new HashSet<>();
        // for (String str:animals.keySet()) {
        //     pot = new HashSet<>();
        //     for (String s:animals.keySet()) if (!s.equals(str)) pot.add(s);
            
            
        //     while (pot.size() > 1) {
        //         for (String feat:feats) {
        //             System.out.println(feat);
        //             if (animals.get(str).contains(feat)) {
        //                 count++;
        //                 for (String ani:pot) {
        //                     if (!animals.get(ani).contains(feat)) rem.add(ani);
        //                 }
                        
        //                 for (String sg : rem) pot.remove(sg);
        //                 rem = new HashSet<>();
        //             } else if (!(animals.get(str).contains(feat))) {
        //                 for (String ani:pot) {
        //                     if (animals.get(ani).contains(feat)) rem.add(ani);
        //                 }
                        
        //                 for (String sg : rem) pot.remove(sg);
        //                 rem = new HashSet<>();
        //             }
        //         } 
        //         for (String rts:rem) {
        //             for (String fea:animals.get(rts)) {
        //                 feats.remove(fea);
        //             }
        //         }
        //     }
        //     //System.out.println(count + " "+str);
        //     max = (count > max) ? count:max;
        //     count = 0;
        // }
        System.out.println(max+1);
        out.println(max+1);
        out.close();
    }
    
}
