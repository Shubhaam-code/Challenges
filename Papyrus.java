import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                b[i] = Integer.parseInt(st.nextToken());

            long ans = Long.MAX_VALUE;

            // Case 1 : No reorder
            boolean ok = true;
            long cost = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] < b[i]) {
                    ok = false;
                    break;
                }
                cost += (a[i] - b[i]);
            }
            if (ok)
                ans = Math.min(ans, cost);

            // Case 2 : Reorder
            int[] sa = a.clone();
            int[] sb = b.clone();

            Arrays.sort(sa);
            Arrays.sort(sb);

            ok = true;
            cost = c;

            for (int i = 0; i < n; i++) {
                if (sa[i] < sb[i]) {
                    ok = false;
                    break;
                }
                cost += (sa[i] - sb[i]);
            }

            if (ok)
                ans = Math.min(ans, cost);

            if (ans == Long.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(ans);
        }
    }
}