import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            long c = sc.nextLong();

            long[] a = new long[n];
            long sum = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                sum += a[i];
            }

            Arrays.sort(a);

            // Initially, every element is removed separately
            long ans = sum - (long) n * c;

            // Pair smallest with largest
            for (int i = 0; i < n / 2; i++) {

                long smaller = a[i];

                // Pairing gives benefit = c - smaller
                if (smaller < c) {
                    ans += c - smaller;
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}