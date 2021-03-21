import java.io.*;
import java.util.*;

public class evolution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("evolution.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));

        // BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\cowevolution\\2.in"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\cowevolution\\out.txt")));

        Scanner scanner = new Scanner(in);
        int len = scanner.nextInt();
        ArrayList<Set<String>> tree = new ArrayList<Set<String>>();

        TreeMap<String, ArrayList<Integer>> invTree = new TreeMap<String, ArrayList<Integer>>();

        Set<String> uni = new HashSet<String>();
        int numWords = 0;

        for (int i = 0; i < len; i++) {
            numWords = scanner.nextInt();
            if (numWords >= 0) {
                tree.add(new TreeSet<String>());

                for (int j = 0; j < numWords; j++) {
                    tree.get(i).add(scanner.next());
                }
            }
        }


        for (int i = 0; i < len; i++) {
            for (String str : tree.get(i)) {
                uni.add(str);
            }
        }
        
        for (String str: uni) invTree.put(str, new ArrayList<Integer>());
        String temp;
        for (int i = 0; i < len; i++) {
            for (String str : tree.get(i)) {
                invTree.get(str).add(i);
            }
        }
      
        scanner.close();
        String rvalue = "yes";

        for (String stt : invTree.keySet()) {
            if (!invTree.isEmpty()) {
                for (String str : invTree.keySet()) {
                    if (str != stt) {
                        if (invTree.get(str).containsAll(invTree.get(stt)) || invTree.get(stt).containsAll(invTree.get(str))) {
                            continue;
                        } else if (isPartial(invTree.get(stt), invTree.get(str)) != -1) {
                            rvalue = "no";
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(rvalue);
        out.println(rvalue);
        out.close();

    }

    static String isPartial(Set<String> set1, Set<String> set2) {
        for (String str : set1) {
            if (set2.contains(str)) return str;
        }
        return "notThere";
    }
    
    static int isPartial(ArrayList<Integer> ar1, ArrayList<Integer> ar2) {
        for (int i = 0; i < ar1.size(); i++) {
            if (ar2.contains(ar1.get(i))) return ar1.get(i);
        }
        return -1;
    }
}
