import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int MAX = 200001;
        boolean[] prime = new boolean[MAX + 1];

        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        // Sieve of Eratosthenes
        for (int i = 2; i * i <= MAX; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }

        while (T-- > 0) {
            int n = sc.nextInt();

            if (prime[n + 1]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}