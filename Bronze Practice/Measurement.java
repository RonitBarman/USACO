/*
ID: Ronit Barman [ronitba4]
LANG: JAVA
PROG: mixmilk
*/

import java.io.*;
import java.util.*;

class Measurement {
    public BufferedReader f; 
    public PrintWriter out; 
    public int count = 0; 
    public TreeMap<Integer, Logg> log;
    public TreeMap<String, Integer> current;

    public Measurement() throws IOException {
        this.f = new BufferedReader(new FileReader("measurement.in"));
        this.out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        //this.f = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\measurement\\in.txt"));
        //this.out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\measurement\\out.txt")));
        
        this.count = 0; 
        this.log = new TreeMap<>();
        this.current = new TreeMap<>();
        this.current.put("Bessie", 7); this.current.put("Mildred", 7); this.current.put("Elsie", 7);
    }

    public static void main(String[] args) throws IOException {
        Measurement mmt = new Measurement();
        StringTokenizer st = new StringTokenizer(mmt.f.readLine());


        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            String[] vals = mmt.f.readLine().split(" ");   
            mmt.log.put(Integer.parseInt(vals[0]), mmt.new Logg(vals[1], Integer.parseInt(vals[2])));
        }

        for (Map.Entry<Integer, Logg> entry : mmt.log.entrySet()) {
            TreeMap<String, Integer> previous = new TreeMap<>(); 
            previous.put("Bessie", mmt.current.get("Bessie")); 
            previous.put("Mildred", mmt.current.get("Mildred")); 
            previous.put("Elsie", mmt.current.get("Elsie")); 
            mmt.current.replace(entry.getValue().str, mmt.current.get(entry.getValue().str) + entry.getValue().num);
            mmt.updateLeaderboard(previous);
        }

        mmt.out.print(mmt.count);
        mmt.out.close();
        mmt.f.close();
    }
    

    class Logg {
        public String str;
        public Integer num;
        public Logg() {}
        public Logg(String str, int num) {this.str = str; this.num = num;}
    }

    void maxes(TreeMap<String, Integer> previous, TreeMap<String, Integer> current) {
        
    }

    void updateLeaderboard(TreeMap<String, Integer> map) {
        String[] leaderlist = new String[maxMap(this.current).size()];
        String[] leaderlist2 = new String[maxMap(map).size()];
        int count = this.count;        
        for (int i = 0; i < maxMap(this.current).size(); i++) {
            leaderlist[i] = maxMap(this.current).get(i);
        }

        for (int i = 0; i < maxMap(map).size(); i++) {
            leaderlist2[i] = maxMap(map).get(i);
        }
        Arrays.sort(leaderlist); Arrays.sort(leaderlist2);
        
        if (!Arrays.equals(leaderlist, leaderlist2)) {
            count += 1;
            
        }
        this.count = count;

    }
    static ArrayList<String> maxMap(  TreeMap<String, Integer> map) {
        int max = -1;
        ArrayList<String> keys = new ArrayList<>();
    
        if (map.get("Bessie") > max) {
            max = map.get("Bessie");
            keys.add("Bessie");
            if (map.get("Elsie") > max) {
                max = map.get("Elsie");
                keys.removeAll(keys);
                keys.add("Elsie");
                if (map.get("Mildred") > max) {
                    max = map.get("Mildred");
                    keys.removeAll(keys);
                    keys.add("Mildred");
                } else if (map.get("Mildred") == max) {
                    keys.add("Mildred");
                }
            } else if (map.get("Mildred") > max) {
                keys.removeAll(keys);
                keys.add("Mildred");
            } else if (map.get("Mildred") == max && map.get("Elsie") == max) {
                    keys.add("Elsie");
                    keys.add("Mildred");
            } else if (map.get("Elsie") == max) {
                keys.add("Elsie");
            } else if (map.get("Mildred") == max) {
                keys.add("Mildred");
            }
        }
        return keys;
    }
} 


// public static void main(String[] args) throws IOException {
//     BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
//     PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
//     int count = 0; 
//     measurement mmt = new measurement();
//     TreeMap<Integer, Logg> cows = new TreeMap<>();
//     TreeMap<String, Integer> current = new TreeMap<>();
//     current.put("Bessie", 7); current.put("Mildred", 7); current.put("Elsie", 7);

//     StringTokenizer st = new StringTokenizer(f.readLine());
//     int m = Integer.parseInt(st.nextToken());

//     for (int i = 0; i < m; i++) {
//         String[] vals = f.readLine().split(" ");   
//         cows.put(Integer.parseInt(vals[0]), mmt.new Logg(vals[1], Integer.parseInt(vals[2])));
//     }



//     for (int i = cows.firstKey(); i <= cows.lastKey(); i++) {
//         Map<String, Integer> previous = current;
//         if (cows.containsKey(i)) {
//             current.replace(cows.get(i).str, current.get(cows.get(i).str)+cows.get(i).num);
//         }
//     }


//     f.close();
//     out.close();
// }