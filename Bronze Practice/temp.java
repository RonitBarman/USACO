import java.util.ArrayList;
import java.util.Collections;

public class temp {
    public static void main(String[] args) {
        
        //System.out.println(Integer.toOctalString(0221)+" O");
        //String test = "0221";
        //System.out.println(sumOfLastRow(10, 10, 10));
        //System.out.println(toDecimal(221));
        rearrangeString("BOOOKEEEPEEERR", 4);

    }
    public static int maxStreak(String b) {
        int count = Integer.MIN_VALUE;
        for (char c = 'A'; c <= 'Z'; c++) {
            int ca = 0;
            int cn = 0;
            for (int i = 0; i < b.length(); i++) {
                if (i == 0 && b.charAt(0) == c) cn++;
                else if (i == b.length()-1 && b.charAt(i) == c) {
                    cn++;
                    ca = Math.max(ca, cn);
                }
                else if (cn == 0 && b.charAt(i) == c) cn++;
                else if (b.charAt(i) == c && b.charAt(i) == c) cn++;
                else {
                    ca = Math.max(ca, cn);
                    cn=0;
                }
            }
            count = Math.max(count, ca);
        }
        return count;
    }
    
    public static String rearrangeString(String s, int n) {
        char[] string = s.toCharArray();
        boolean[] taken = new boolean[s.length()];
        ArrayList<String>[] letters = new ArrayList[maxStreak(s)];
        for (int i = 0; i < letters.length; i++) letters[i] = new ArrayList<String>();
        for (char c = 'A'; c <= 'Z'; c++) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (j == 0) {
                    if (string[j] == c) count++; 
                }
                else if (j == s.length()-1 && string[j] == c) {
                    if (count == 0) letters[count].add(c+"");
                    else {
                        count++;
                        String temp = "";
                        for (int k = 0; k < count; k++) {
                            temp += c+"";
                        }
                        letters[count-1].add(temp);
                    }
                }
                else if (count == 0 && string[j] == c) count++;
                else if (string[j] == c && string[j-1] == c) count++;
                else {
                    if (count == 0) continue;
                    String temp = "";
                    for (int k = 0; k < count; k++) {
                        temp += c+"";
                    }
                    letters[count-1].add(temp);
                    count = 0;
                }
            }
        }
        
        for (int i = 0; i < letters.length; i++) if (!letters[i].isEmpty()) Collections.sort(letters[i]);
        String b = "";
        for (int i = letters.length-1; i >= 0; i--) {
            for (int j = 0; j < letters[i].size(); j++) {
                b += letters[i].get(j);
            }
        }
        ArrayList<Integer> skip = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            int cn = 0;
            for (int i = 0; i < b.length(); i++) {
                if (i == 0 && b.charAt(0) == c) cn++;
                else if (i == b.length()-1 && b.charAt(i) == c) {
                    cn++;
                    if (cn > n) {
                        for (int k = i-(cn-n); k < i; k++) skip.add(k);
                    }
                }
                else if (cn == 0 && b.charAt(i) == c) cn++;
                else if (b.charAt(i) == c && b.charAt(i) == c) cn++;
                else {
                    if (cn > n) {
                        for (int k = i-(cn-n); k < i; k++) skip.add(k);
                    }
                    cn=0;
                }
            }
        }
        String bigString = "";
        for (int i = 0; i < b.length(); i++) {
            if (!skip.contains(i)) bigString += b.charAt(i)+"";
        }
        System.out.println(bigString);
        return bigString;
    }

    public static int sumOfLastRow(int s, int d, int r) {
        int n = 0;
        for (int i = r; i >= 1; i--) n+=i;
        String[] triangle = new String[n];
        int sum = toDecimal(s);
        
        for (int i = 0; i < n; i++) {
            System.out.print(sum+" s");
            triangle[i] = Integer.toOctalString(sum);
            System.out.println("  "+triangle[i]+" T");
            sum += toDecimal(d);
        }
        
        
        String[] last = new String[r];
        int c = 0;
        for (int i = n-1; i > n-r-1; i--) {
            last[c] = 
            triangle[i];
            c++;
        }
        //String total = "";
        //for (int i = 0; i < n; i++) System.out.println(triangle[i]+" T");
        int dsum = 0;
        for (String str:last) {
            for (String digit:str.split("")) {
                dsum+=Integer.parseInt(digit);
            }
        }
        return dsum;
    }
    public static int toDecimal(int num) {
        String str = Integer.toString(num);
        int sum = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            sum += Integer.parseInt(str.charAt(i)+"")*Math.pow(8, len-1-i);
            //System.out.println(sum);
        }
        return sum;
    }
    
}
