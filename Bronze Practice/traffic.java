import java.util.*;

import java.io.*;


public class traffic {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("traffic.in")));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] sensors = new int[n][2];
        String[] type = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            type[i] = st.nextToken();
            sensors[i][0] = Integer.parseInt(st.nextToken());
            sensors[i][1] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int[] temp = new int[2];
        while (!type[i].equals("none")) {
            if (type[i].equals("on")) {
                temp[1] -= sensors[i][1];
                temp[0] -= sensors[i][0];
            }
            if (type[i].equals("off")) {
                temp[1] += sensors[i][1];
                temp[0] += sensors[i][0];
            }
            i++;
        }
        boolean streak = true;
        int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE;
        while (streak) {
            if (type[i].equals("none")) {
                if (sensors[i][0] > max) max = sensors[i][0];
                if (sensors[i][1] < min) min = sensors[i][1];
                i++;
            } else streak = false;

        }
        int[] pre = new int[2];
        pre[0] = max+temp[1]; pre[1] = min+temp[0];

        i = n-1;
        temp = new int[2];
        while(!type[i].equals("none")) {
            if (type[i].equals("on")) {
                temp[1] += sensors[i][1];
                temp[0] += sensors[i][0];
            }
            if (type[i].equals("off")) {
                temp[1] -= sensors[i][1];
                temp[0] -= sensors[i][0];
            }
            i--;
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        streak = true;
        while (streak) {
            if (type[i].equals("none")) {
                if (sensors[i][0] > max) max = sensors[i][0];
                if (sensors[i][1] < min) min = sensors[i][1];
                i--;
            } else streak = false;
        }
        int[] post = new int[2];
        post[0] = max+temp[1]; post[1] = min+temp[0];
        

        System.out.println(pre[0]+" "+pre[1]);
        System.out.println(post[0]+" "+post[1]);
        out.println(pre[0]+" "+pre[1]);
        out.println(post[0]+" "+post[1]);
        out.close();

    }
}
