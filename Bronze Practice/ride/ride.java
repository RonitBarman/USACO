/*
ID: Ronit Barman [ronitba4]
LANG: JAVA
PROG: ride
*/
import java.io.*;
import java.util.StringTokenizer;


class ride {
    public static void main(String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String[][] code = new String[2][1];
        int num = 0;
        int temp = 1;                                                                                                                                            
        
        while (f.ready()) {
            code[num][0] = f.readLine();
            num ++;
        }
        System.out.println(code[0][0]);
        System.out.println(code[1][0]);
        for (int i = 0; i < code[0][0].split("").length; i++) {
            char[] c = code[0][0].split("")[i].toCharArray();
            temp *= (int) c[0] - 64;
        }
        int v  = temp % 47;
        temp = 1;
        for (int i = 0; i < code[1][0].split("").length; i++) {
            char[] c = code[1][0].split("")[i].toCharArray();
            temp *= (int) c[0] - 64;
        }
        int v2 = temp % 47;
        out.println((v == v2) ? "GO":"STAY");
        out.close();
        f.close();
    }
}