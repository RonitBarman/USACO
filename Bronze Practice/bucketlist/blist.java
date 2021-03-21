/*
ID: Ronit Barman [ronitba4]
LANG: JAVA
PROG: mixmilk
*/

import java.io.*;
import java.util.*;


class blist {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("blist.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        int bcount = 0;
		int[] clock = new int[1000];
		int max = 0;
        int min = 1001;

        StringTokenizer st = new StringTokenizer(f.readLine());
        int start; int stop; int bkts;
        int num = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(f.readLine());
            start = Integer.parseInt(st.nextToken());
            stop = Integer.parseInt(st.nextToken());
            bkts = Integer.parseInt(st.nextToken());
            clock[start] = bkts;
			clock[stop] = -bkts;
			max = Math.max(max, stop);
			min = Math.min(min, start);
        }
        // for (int i = 0; i < bkts.size(); i++) {
        //     clock[start.get(i)] = bkts.get(i);
        //     clock[stop.get(i)] = -bkts.get(i);
        // }
        
        int highBkt = 0;
        for (int t = min; t <= max; t++) {
            bcount += clock[t];
            if (bcount > highBkt) {
                highBkt = bcount;
            }
        }
        out.println(highBkt);
        f.close();
        out.close();

    }
//     Copyright (c) 2018 Jeffrey Meng - Licensed under the Apache 2.0 License
// USACO December 2018 (2) - Bucket List.


// 	public static void main(String[] args) throws IOException {
// 		// Use BufferedReader rather than RandomAccessFile; it's much faster
// 		BufferedReader f = new BufferedReader(new FileReader("blist.in"));


// 		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));

//         StringTokenizer st = new StringTokenizer(f.readLine());
// 		int n = Integer.parseInt(st.nextToken());
// 		int[][] data = new int[n][3];

// 		String[] line;
// 		for (int i = 0; i < n; i ++) {
// 			line = f.readLine().split(" ");
// 			for (int j = 0; j < 3; j ++) {
// 				data[i][j] = Integer.parseInt(line[j]);
// 			}
// 		}
// 		String[] result = solve(n, data);

//         //doesn't work well with large outputs.
        
// 			out.println(result[0]);
		
// 		out.close();
// 	}

	// public static String[] solve(int n, int[][] data) {

	// 	String[] out = new String[1];


	// 	HashMap<Integer, Integer> bucketsAtTime = new HashMap<Integer, Integer>();
	// 	int maxIndex = 0, current;
	// 	int maxAmt = -1;

	// 	// We have a hashmap of the number of buckets at each time.
	// 	// For each cow, we increment the number of buckets needed at
	// 	// that time by the number of buckets the cow requires.

	// 	for (int i = 0; i < n; i ++) {
	// 		for (int j = data[i][0]; j < data[i][1]; j ++) {

	// 		    // If the time has not been initialized, initialize it at zero.
	// 			if (!(bucketsAtTime.containsKey(j))) {
	// 				bucketsAtTime.put(j, 0);
	// 			}

	// 			// Set the number of buckets at the current time to the number of buckets this cow needs
	// 			// plus the number of buckets already there.
	// 			current = data[i][2] + bucketsAtTime.get(j);
	// 			bucketsAtTime.put(j, current);

	// 			// Check if this time has the most buckets, if it does, save the time and amount.
	// 			if (current > maxAmt) {
	// 				maxIndex = j;
	// 				maxAmt = current;
	// 			}
	// 		}
	// 	}


	// 	out[0] = maxAmt + "";


	// 	return out;
	// }
}
