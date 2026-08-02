import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final BufferedInputStream in = new BufferedInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();

            int[] P = new int[n + 1];
            int[] Q = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                int x = fs.nextInt();

                // Prefix for left condition
                P[i] = P[i - 1] + (x == 1 ? 1 : -1);

                // Prefix for middle condition
                Q[i] = Q[i - 1] + (x == 3 ? -1 : 1);
            }

            int[] suffixMax = new int[n + 2];
            suffixMax[n] = Integer.MIN_VALUE;

            for (int i = n - 1; i >= 1; i--) {
                suffixMax[i] = Math.max(Q[i], suffixMax[i + 1]);
            }

            boolean ok = false;

            for (int i = 1; i <= n - 2; i++) {
                if (P[i] >= 0 && suffixMax[i + 1] >= Q[i]) {
                    ok = true;
                    break;
                }
            }

            out.append(ok ? "YES\n" : "NO\n");
        }

        System.out.print(out);
    }
}