import java.io.*;
import java.util.*;

public class XorSortingEasyVersion {

    static class FastScanner {
        private final InputStream in = System.in;
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

        int T = fs.nextInt();

        while (T-- > 0) {
            int n = fs.nextInt();
            int q = fs.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                b[i] = a[i];
            }

            Arrays.sort(b);

            HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                map.computeIfAbsent(b[i], k -> new ArrayDeque<>()).add(i);
            }

            int block = 1;

            for (int i = 0; i < n; i++) {
                int target = map.get(a[i]).poll();

                int d = i ^ target;

                if (d != 0) {
                    int cur = Integer.highestOneBit(d) << 1;
                    block = Math.max(block, cur);
                }
            }

            if (block == 1)
                out.append(0).append('\n');
            else
                out.append(block / 2).append('\n');
        }

        System.out.print(out);
    }
}