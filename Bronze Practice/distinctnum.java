import java.util.*;
import java.io.*;


class Distinctnum {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\ronit\\RandomJava\\USACO\\distinct\\";
        BufferedReader f = new BufferedReader(new FileReader(path+"in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path+"out.txt")));
        HashSet<Integer> nums = new HashSet<>();
        f.readLine();
        StringTokenizer st = new StringTokenizer(f.readLine());
        while (st.hasMoreTokens()) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        out.println(nums.size());
        out.close();
        f.close();


    }
}