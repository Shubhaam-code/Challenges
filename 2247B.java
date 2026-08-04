import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            if (m < k) {
                out.append("NO\n");
                continue;
            }

            out.append("YES\n");

            long[] pref = new long[n + 1];
            for (int i = 0; i <= n; i++) {
                pref[i] = i % k;
            }

            for (int i = 1; i <= n; i++) {
                long diff = (pref[i] - pref[i - 1]) % m;
                if (diff < 0) diff += m;
                if (diff == 0) diff = m;

                out.append(diff);
                if (i != n) out.append(" ");
            }
            out.append("\n");
        }

        System.out.print(out);
    }
}