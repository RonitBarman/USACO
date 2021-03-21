/*
ID: Ronit Barman [ronitba4]
LANG: JAVA
PROG: gift1
*/

import java.io.*;
import java.util.*;

class gift1 {
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\giftgivers\\in.txt"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\giftgivers\\out.txt")));

        BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        Scanner scanner = new Scanner(in);
        int np = scanner.nextInt();
        String[] names = new String[np];
        int[] balance = new int[np];
        for (int i = 0; i < np; i++) {
            names[i] = scanner.next();
        }
        
        String current = "";
        String name = "";
        int value = 0;
        int div = 0;
        int quo = 0;
        boolean done = false;
        while (scanner.hasNext()) {
            current = scanner.next();
            value = scanner.nextInt();
            div = scanner.nextInt();
            if (div == 0) quo = 0;
            else quo = value/div;

            for (int i = 0; i < div; i ++) {
                name = scanner.next();
                for (int j = 0; j < np; j++) {
                    if (names[j].equals(current) && done == false) {
                        balance[j] -= quo*div;
                        done = true;
                    }
                    else if (names[j].equals(name)) balance[j] += quo;
                }
                // if (names[i].equals(name)) balance[i] += quo;
                // else if (names[i].equals(current)) balance[i] -= quo*div;
            }
            done = false;
        }
        scanner.close();

        for (int i = 0; i < np; i++) {
            out.println(names[i]+" "+balance[i]);
            System.out.println(names[i]+" "+balance[i]);
        }
        out.close();
    }
}