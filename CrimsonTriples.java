import java.io.*;

public class CrimsonTriples {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long ans = 0;

            for (int b = 1; b <= n; b++) {
                long cnt = n / b;
                ans += cnt * cnt;
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}