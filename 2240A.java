import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            long ans = 0;

            while (n > 0) {
                // We can create one set bit with cost 1,
                // then next bit costs 2, then 4, then 8...
                
                long take = Math.min(k, n);

                ans += take;
                n -= take;

                // After using 'take' numbers at current level,
                // their next set bit costs double.
                k = take;
                
                if (k == 0) break;

                // Move to next power-of-2 cost
                n /= 2;
            }

            System.out.println(ans);
        }

        sc.close();
    }
}