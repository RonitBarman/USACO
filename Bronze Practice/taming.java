import java.util.*;


import java.io.*;



public class taming {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("taming.in")));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] days = new int[n];
        for (int i = 0; i < n; i++) days[i] = Integer.parseInt(st.nextToken());

        boolean contra = false;
        int[] breakout = new int[n];
        if (days[0] != -1 && days[0] != 0) contra = true;

        breakout[0] = 1;
        days[0] = 0;
        int temp = 0;
        
        for (int i = 0; i < n; i++) {
            if (days[i] != -1 && days[i] != 0) {
                temp = days[i];
                for (int j = i; temp >= 0; j--) {
                    if (days[j] == -1 || days[j] == temp) {
                        days[j] = temp;
                    }
                    else {
                        contra = true;
                        break;
                    }
                    temp--;
                }
                if (contra) break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (days[i] == -1) continue;
            else {
                breakout[i-days[i]] = 1; 
                if (!(days[i] == 0)) breakout[i] = -1;
            }
        }
        // for (int i = 0; i < n; i++) System.out.print(days[i]+" ");
        // System.out.println();
        // for (int i = 0; i < n; i++) System.out.print(breakout[i]+" ");

        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) { 
            if (breakout[i] == 1) min++;
            else if (breakout[i] == 0) max++;
        }
        max += min;
        if (contra) out.println(-1);
        else out.println(min +" "+ max);
        out.close();
        
    }
    
}
