import java.io.*;
import java.util.*;

public class Main {

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
            do {
                c = read();
            } while (c <= ' ');

            int num = 0;
            while (c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }
            return num;
        }
    }

    static void solve(FastScanner fs) throws Exception {
        int n = fs.nextInt();

        ArrayList<Integer> color = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = fs.nextInt();

            if (color.isEmpty() || color.get(color.size() - 1) != x) {
                color.add(x);
                len.add(1);
            } else {
                int last = len.size() - 1;
                len.set(last, len.get(last) + 1);
            }
        }

        int m = color.size();
        int bonus = 0;

        for (int i = 0; i + 1 < m; i++) {
            if (len.get(i) >= 2 && len.get(i + 1) >= 2) {
                bonus = 2;
                break;
            }
        }

        if (bonus < 2) {
            for (int i = 0; i < m; i++) {
                if (len.get(i) < 2) {
                    continue;
                }

                boolean right = false;
                boolean left = false;

                if (i + 1 < m) {
                    right = (i + 2 >= m || !color.get(i).equals(color.get(i + 2)));
                }

                if (i > 0) {
                    left = (i < 2 || !color.get(i).equals(color.get(i - 2)));
                }

                if (right || left) {
                    bonus = 1;
                    break;
                }
            }
        }

        System.out.println(m + bonus);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int TestsNumT = fs.nextInt();

        while (TestsNumT-- > 0) {
            solve(fs);
        }
    }
}