/*
ID: Ronit Barman [ronitba4]
LANG: JAVA
PROG: mixmilk
*/

import java.util.*;

import java.io.*;


class mixmilk {
    public static void main(String[] args) throws IOException {
        

        BufferedReader f = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
        
        int[] a = new int[3];
        int[] c = new int[3];

        StringTokenizer st = new StringTokenizer(f.readLine());
        c[0] = Integer.parseInt(st.nextToken());
        a[0] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());
        c[1] = Integer.parseInt(st.nextToken());
        a[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());
        c[2] = Integer.parseInt(st.nextToken());
        a[2] = Integer.parseInt(st.nextToken());

        int temp = 0;

        for (int i = 0; i < 34; i++) {
            if (i == 33) {
                temp = Math.min(a[0], c[1]-a[1]);
                a[0] -= temp; 
                a[1] += temp;
                break;
            }
            temp = Math.min(a[0], c[1]-a[1]);
            a[0] -= temp;
            a[1] += temp;
            
            temp = Math.min(a[1], c[2]-a[2]);
            a[1] -= temp;
            a[2] += temp;

            temp = Math.min(a[2], c[0]-a[0]);
            a[2] -= temp;
            a[0] += temp;
        }

        out.println(a[0]);
        out.println(a[1]);
        out.println(a[2]);
        f.close();
        out.close();




    }
}