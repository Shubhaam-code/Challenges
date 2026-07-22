import java.io.*;
import java.util.*;

public class NikitaandBooks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            long carry = 0;
            long prev = 0;
            boolean ok = true;

            for (int i = 0; i < n - 1; i++) {
                long current = a[i] + carry;
                long need = prev + 1;

                if (current < need) {
                    ok = false;
                    break;
                }

                carry = current - need;
                prev = need;
            }

            if (ok) {
                long last = a[n - 1] + carry;
                if (last > prev) {
                    out.append("YES\n");
                } else {
                    out.append("NO\n");
                }
            } else {
                out.append("NO\n");
            }
        }

        System.out.print(out);
    }
}