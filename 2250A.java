import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] w = new int[n];

            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
            }

            // n odd hai to possible nahi
            if (n % 2 == 1) {
                System.out.println("NO");
                continue;
            }

            int oddMin = Integer.MAX_VALUE;
            int evenMax = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {

                // i = 0,2,4 -> actual positions 1,3,5
                if (i % 2 == 0) {
                    oddMin = Math.min(oddMin, w[i]);
                }

                // i = 1,3,5 -> actual positions 2,4,6
                else {
                    evenMax = Math.max(evenMax, w[i]);
                }
            }

            if (evenMax < oddMin - 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}