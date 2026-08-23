import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] a = new int[n];
            Map<Integer, Integer> freq = new HashMap<>();

            int total = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                total += a[i];

                freq.put(a[i], freq.getOrDefault(a[i], 0) + 1);
            }

            int maxFreq = 0;

            for (int f : freq.values()) {
                maxFreq = Math.max(maxFreq, f);
            }

            // We can arrange all cards without ever getting
            // two equal cards consecutively.
            if (maxFreq <= (n + 1) / 2) {
                System.out.println(total);
                continue;
            }

            int answer = 0;

            // x = value whose two consecutive cards
            // eventually trigger the shield
            for (int x : freq.keySet()) {

                if (freq.get(x) < 2)
                    continue;

                // m = number of cards before the final x, x
                for (int m = 0; m <= n - 2; m++) {

                    /*
                     * Before x,x:
                     *
                     * x can appear at most floor(m/2)
                     * because the sequence must end with
                     * something different from x.
                     */
                    int capX = Math.min(freq.get(x), m / 2);

                    /*
                     * Any other value can appear at most
                     * ceil(m/2).
                     */
                    int capOther = (m + 1) / 2;

                    List<Integer> possible = new ArrayList<>();

                    for (int value : freq.keySet()) {

                        int cap;

                        if (value == x) {
                            cap = capX;
                        } else {
                            cap = Math.min(freq.get(value), capOther);
                        }

                        for (int j = 0; j < cap; j++) {
                            possible.add(value);
                        }
                    }

                    // Not enough cards to create m valid cards
                    if (possible.size() < m)
                        continue;

                    // Take the largest possible m cards
                    possible.sort(Collections.reverseOrder());

                    int damage = 2 * x;

                    for (int i = 0; i < m; i++) {
                        damage += possible.get(i);
                    }

                    answer = Math.max(answer, damage);
                }
            }

            System.out.println(answer);
        }

        sc.close();
    }
}