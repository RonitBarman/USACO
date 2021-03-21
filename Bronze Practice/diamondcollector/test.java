public class test {
    public static void main(String[] args) {
        int[] cows = {2,2,3,-2};
        tossBall(cows, 4);

        System.out.println("ans "+tossBall(cows, 5));

    }

    static int tossBall(int[] cows, int n) {
        int index = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("i"+i);
            if (cows[index] < 0) {
                index = cows.length - cows[index] - 1;
            } else {
                index = ((index + cows[index]) % cows.length);
                System.out.println(index);
            }
        }

        return index;
        
    
    }
}
