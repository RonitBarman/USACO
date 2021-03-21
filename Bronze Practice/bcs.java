// ####
// #..#
// #.##
// ....

// .#..
// .#..
// ##..
// ....

// ####
// ##..
// #..#
// ####

// ....
// .### .#..
// .#.. .#..
// .#.. ##..


import java.util.*;
import java.io.*;


public class bcs {
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("bcs.in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcs.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<String>> orig = new ArrayList<>();
        ArrayList<ArrayList<String>> piece = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<String>>> pieces = new ArrayList<>();
        

        for (int i = 0; i < n; i++) orig.add(toArrayList(in.readLine().split("")));
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) piece.add(toArrayList(in.readLine().split("")));
            pieces.add(piece);
            piece = new ArrayList<>();
            
        }
        outer:
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (i != j) {
                        shave(pieces.get(i)); shave(pieces.get(j));
                        
                        if (mergeTop(pieces.get(i), pieces.get(j)).equals(orig) || mergeTop(pieces.get(j), pieces.get(i)).equals(orig)) {
                            if (i < j) {
                                System.out.println(i+1); 
                                System.out.println(j+1);
                            } else {
                                System.out.println(i+1); 
                                System.out.println(j+1);
                            }
                            break outer;
                        } else if (mergeRight(pieces.get(i), pieces.get(j)).equals(orig) || mergeRight(pieces.get(j), pieces.get(i)).equals(orig)) {
                            if (i < j) {
                                System.out.println(i+1); 
                                System.out.println(j+1);
                            } else {
                                System.out.println(i+1); 
                                System.out.println(j+1);
                            }
                            break outer;
                        }
                    }
                }
            }
    }

    static ArrayList<ArrayList<String>> mergeTop(ArrayList<ArrayList<String>> ar1, ArrayList<ArrayList<String>> ar2) {
        ArrayList<ArrayList<String>> comb = new ArrayList<>();
        comb.addAll(ar2);
        comb.addAll(ar1);
        return comb;
        
    }
    static ArrayList<ArrayList<String>> mergeRight(ArrayList<ArrayList<String>> ar1, ArrayList<ArrayList<String>> ar2) {
        ArrayList<ArrayList<String>> comb = new ArrayList<>();
        comb.addAll(ar1);
        for (int i = 0; i < comb.size(); i++) {
            for (int j = 0; j < ar2.get(i).size(); j++) {
                comb.get(i).add(ar2.
                get(i).
                get(j));
            }
        }
        return comb;
    }

    static ArrayList<ArrayList<String>> shave(ArrayList<ArrayList<String>> ar1) {
        ArrayList<ArrayList<String>> ar = new ArrayList<>();
        for (int i = 0; i < ar1.size(); i++) ar.add(ar1.get(i));
        for (int i = 0; i < ar.size(); i++) {
            if (allDot(ar, i, true)) ar.remove(i);
        }
        for (int i = 0; i < ar.size(); i++) {
            if (allDot(ar, i, false)) {
                for (int j = 0; j < ar.size(); j++) {
                    ar.get(j).remove(i);
                }
            }
        }
        return ar;
        
    }

    static boolean allDot(ArrayList<ArrayList<String>> ar, int i, boolean row) {
        if (row) {
            for (String string : ar.get(i)) {
                if (!string.equals(".")) return false;
            }
            return true;
        } else {
            for (int j = 0; j < ar.size(); j++) {
                if (!ar.get(j).get(i).equals(".")) return false;
            }
            return true;
        }
    }
    static ArrayList<String> toArrayList(String[] ar) {
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < ar.length; i++) ret.add(ar[i]);
        return ret;
    }

}
