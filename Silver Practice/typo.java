import java.io.*;
import java.util.*;

public class typo {
	public static void main(String[] args) throws IOException {
    	BufferedReader in = new BufferedReader(new FileReader("typo.in"));
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("typo.out")));

		String str = in.readLine();
		int op = 0;
		int cp = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') op++;
			else cp++;
		}
		
		if (str.length()%2 != 0) out.println(0);
		else out.println(Math.abs(op-cp)*2);
		out.close();
		System.out.println(Math.abs(op-cp)*2);
	}
}