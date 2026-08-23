import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            // First k must be R and last k must be L.
            // If they overlap, impossible.
            if (2 * k > n) {
                System.out.println(-1);
                continue;
            }

            int ans = 0;

            // First k positions must be R
            for (int i = 0; i < k; i++) {
                if (s.charAt(i) == 'L') {
                    ans++;
                }
            }

            // Last k positions must be L
            for (int i = n - k; i < n; i++) {
                if (s.charAt(i) == 'R') {
                    ans++;
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}