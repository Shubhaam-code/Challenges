import java.io.*;
import java.util.*;

public class Problem {
    static final int MOD = 998244353;
    static final int MAX = 501;

    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];

    static long modPow(long a, long e) {
        long res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            e >>= 1;
        }
        return res;
    }

    static long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    static int[] a;
    static long[][] g;
    static long[][][] f;

    static long w(int i, int k) {
        if (i == k) {
            return a[k] <= 0 ? 1 : 0;
        } else {
            if (a[k] != -1) return f[i][k - 1][a[k]];
            return g[i][k - 1];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fact[0] = 1;
        for (int i = 1; i < MAX; i++) fact[i] = fact[i - 1] * i % MOD;

        invFact[MAX - 1] = modPow(fact[MAX - 1], MOD - 2);
        for (int i = MAX - 2; i >= 0; i--)
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            a = new int[n + 1];

            int sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] > 0) sum += a[i];
            }

            if (sum >= n) {
                System.out.println(0);
                continue;
            }

            a[n] = -1;

            f = new long[n + 1][n][];
            g = new long[n + 1][n];

            for (int r = 0; r < n; r++) {
                if (a[r + 1] != -1) {
                    for (int l = 0; l < n; l++) {
                        f[l][r] = new long[a[r + 1] + 1];
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                f[i][i - 1] = new long[1];
                f[i][i - 1][0] = 1;
                g[i][i - 1] = 1;
            }

            for (int l = n - 1; l >= 0; l--) {
                for (int r = l; r < n; r++) {

                    if (a[r + 1] == -1) {

                        long cur = 0;

                        for (int k = l; k <= r; k++) {
                            cur += comb(r - l, k - l) * w(l, k) % MOD * g[k + 1][r] % MOD;
                            cur %= MOD;
                        }

                        g[l][r] = cur;

                    } else {

                        for (int c = 1; c <= a[r + 1]; c++) {

                            long cur = 0;

                            for (int k = l; k <= r; k++) {
                                cur += comb(r - l, k - l) * w(l, k) % MOD
                                        * f[k + 1][r][c - 1] % MOD;
                                cur %= MOD;
                            }

                            f[l][r][c] = cur;
                        }
                    }
                }
            }

            System.out.println(w(0, n));
        }
    }
}