import java.util.*;

import java.io.*;


public class triangles {
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ronit\\RandomJava\\USACO\\triangles\\2.in"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\ronit\\RandomJava\\USACO\\triangles\\out.txt")));


        BufferedReader in = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));

        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        scanner.close();

        double area = 0;
        double maxArea = Double.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    if (!(x[i] == x[j] || y[i] == y[j])) continue;
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            if (x[i] == x[j]) {
                                if (!(y[j] == y[k] || y[i] == y[k])) continue;
                                area = 0.5 * Math.abs(y[i]-y[j]) * Math.abs(x[j]-x[k]);
                                maxArea = (area > maxArea) ? area : maxArea;
                            } else {
                                if (!(x[j] == x[k] || x[i] == x[k])) continue;
                                area = 0.5 * Math.abs(y[i]-y[j]) * Math.abs(x[j]-x[k]);
                                maxArea = (area > maxArea) ? area : maxArea;
                            }
                        }
                    }
                }
            }
        }
        System.out.println((int) (maxArea*2));
        out.println((int) (maxArea*2));
        out.close();
    }
    
}
