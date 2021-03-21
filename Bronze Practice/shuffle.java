import java.util.*;

import java.io.*;



public class shuffle {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(new File("shuffle.in")));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new FileWriter(new File("shuffle.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int[] pos = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) pos[i] = Integer.parseInt(st.nextToken());
        int[] ids = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) ids[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            int[] temp = Arrays.copyOf(ids, n);
            for (int j = 0; j < n; j++) {
                ids[j] = temp[pos[j]-1];
            }
        }
        for (int i : ids) out.println(i);
        out.close();


    }
    
}
