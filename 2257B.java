import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[] a = new long[n];
            long[] b = new long[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }

            int ia = 0;
            int ib = 0;

            while (true) {

                // Bea attacks Ver
                b[ib]--;

                // Ver's current mountain becomes 0
                if (b[ib] == 0) {
                    if (ib == m - 1) {
                        System.out.println(1);
                        break;
                    }
                }

                // Bea jumps if next mountain is exactly 1 higher
                if (ia + 1 < n && a[ia + 1] == a[ia] + 1) {
                    ia++;
                }

                // Ver attacks Bea
                a[ia]--;

                // Bea's current mountain becomes 0
                if (a[ia] == 0) {
                    if (ia == n - 1) {
                        System.out.println(2);
                        break;
                    }
                }

                // Ver jumps
                if (ib + 1 < m && b[ib + 1] == b[ib] + 1) {
                    ib++;
                }
            }
        }
    }
}