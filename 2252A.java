import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];
            HashMap<Integer, Integer> freq = new HashMap<>();

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                freq.put(a[i], freq.getOrDefault(a[i], 0) + 1);
            }

            int mx = 0;

            for (int count : freq.values()) {
                mx = Math.max(mx, count);
            }

            int k = Math.min(n, 2 * (n - mx) + 2);

            Arrays.sort(a);

            int ans = 0;

            // Take k largest values
            for (int i = n - 1; i >= n - k; i--) {
                ans += a[i];
            }

            System.out.println(ans);
        }

        sc.close();
    }
}