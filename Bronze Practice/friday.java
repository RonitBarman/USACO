/*
ID: Ronit Barman [ronitba4]
LANG: JAVA
PROG: friday
*/

import java.io.*;
import java.util.*;

class friday {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        
        int n = scanner.nextInt();
        scanner.close();

        int[] days = new int[7];

        int[] m31 = {1, 3, 5, 7, 8, 10, 12};
        int[] m30 = {9, 4, 6, 11};


        int dayW = 2;
        int len = 0;
        for (int year = 1900; year < 1900+n; year++) {
            for (int month = 1; month <= 12; month++) {
                if (year%100 == 0 && month == 2) {
                    if (year%400 == 0) len = 29;
                    else len = 28;
                } else if (year%4 == 0 && month == 2) len = 29;
                else if (contains(m31, month)) len = 31;
                else if (contains(m30, month)) len = 30;
                else if (month == 2) len = 28;

                for (int day = 1; day <= len; day++) {
                    if (day == 13) days[dayW]++;
                    if (dayW+1 > 6) dayW = 0;
                    else dayW++;
                }   
            }
        }

        for (int i = 0; i < 7; i++) {
            //System.out.print(days[i]+" ");
            if (i == 6) out.println(days[i]);
            else out.print(days[i]+" ");
        }

        out.close();
    }

    static boolean contains(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) return true;
        }
        return false;
    }
    
}
