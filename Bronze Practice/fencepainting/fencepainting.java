import java.util.*;
import java.io.*;


class fencepainting {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("paint.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));

        // BufferedReader f = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\fencepainting\\in.txt"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\fencepainting\\out.txt")));

        
        int[] fence = new int[101];
        StringTokenizer st = new StringTokenizer("");
        int low = 0;
        int high = 0;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(in.readLine());
            low = Integer.parseInt(st.nextToken());
            high = Integer.parseInt(st.nextToken());
            for (int j = low; j < high; j++) {
                fence[j] = 1;
            }
        }
        f.close();

        
        int sum = 0;
        for (int i = 0; i < fence.length; i++) {
            sum += fence[i];
        }
        
        System.out.println(sum);
        out.println(sum);
        out.close();
    }
    
}
