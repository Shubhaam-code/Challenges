import java.io.*;
import java.util.*;

public class Main {

    static void solve(FastScanner fs) {
        int n = fs.nextInt();
        int k = fs.nextInt();

        int b = n - k;

        for (int ch = 0; ch <= 1; ch++) {

            int b0, b1;

            if (ch == 0) {
                b0 = (b + 1) / 2;
                b1 = b / 2;
            } else {
                b1 = (b + 1) / 2;
                b0 = b / 2;
            }

            // Possible counts of 0 and 1
            // because their difference must be at most 1
            int[][] v;

            if (n % 2 == 0) {
                v = new int[][] {
                    {n / 2, n / 2}
                };
            } else {
                v = new int[][] {
                    {(n + 1) / 2, (n - 1) / 2},
                    {(n - 1) / 2, (n + 1) / 2}
                };
            }

            for (int[] pair : v) {

                int c0 = pair[0];
                int c1 = pair[1];

                if (b0 == 0 && c0 > 0)
                    continue;

                if (b1 == 0 && c1 > 0)
                    continue;

                if (c0 >= b0 && c1 >= b1) {

                    int[] blk0 = new int[b0];
                    int[] blk1 = new int[b1];

                    Arrays.fill(blk0, 1);
                    Arrays.fill(blk1, 1);

                    if (b0 > 0) {
                        blk0[0] += (c0 - b0);
                    }

                    if (b1 > 0) {
                        blk1[0] += (c1 - b1);
                    }

                    StringBuilder s = new StringBuilder();

                    int idx0 = 0;
                    int idx1 = 0;

                    int curr = ch;

                    for (int i = 0; i < b; i++) {

                        if (curr == 0) {

                            int count = blk0[idx0];

                            while (count-- > 0) {
                                s.append('0');
                            }

                            idx0++;
                            curr = 1;

                        } else {

                            int count = blk1[idx1];

                            while (count-- > 0) {
                                s.append('1');
                            }

                            idx1++;
                            curr = 0;
                        }
                    }

                    System.out.println(s);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) {

        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();

        while (t-- > 0) {
            solve(fs);
        }
    }

    // Fast Scanner
    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() {
            if (ptr >= len) {
                try {
                    len = in.read(buffer);
                    ptr = 0;
                } catch (IOException e) {
                    return -1;
                }

                if (len <= 0)
                    return -1;
            }

            return buffer[ptr++];
        }

        int nextInt() {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int res = 0;

            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }

            return res * sign;
        }
    }
}