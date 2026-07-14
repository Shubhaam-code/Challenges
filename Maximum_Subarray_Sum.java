import java.util.Scanner;

public class Maximum_Subarray_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long currentSum = sc.nextLong();
        long maxSum = currentSum;

        for (int i = 1; i < n; i++) {
            long x = sc.nextLong();

            currentSum = Math.max(x, currentSum + x);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
        sc.close();
    }
    
}