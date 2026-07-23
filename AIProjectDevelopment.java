import java.util.*;

public class AIProjectDevelopment {

    static long ceilDiv(long a, long b) {
        return (a + b - 1) / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long z = sc.nextLong();

            // Option 1: Nikita does not use AI
            long withoutAI = ceilDiv(n, x + y);

            // Option 2: Nikita uses AI
            long withAI;

            // Project finishes before AI setup completes
            if (ceilDiv(n, x) <= z) {
                withAI = ceilDiv(n, x);
            } else {
                long writtenDuringSetup = x * z;
                long remaining = n - writtenDuringSetup;
                withAI = z + ceilDiv(remaining, x + 10 * y);
            }

            System.out.println(Math.min(withoutAI, withAI));
        }

        sc.close();
    }
}