import java.io.*;

public class TwoDigitStrings {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String a = br.readLine();
            String b = br.readLine();

            int n = a.length();
            int m = b.length();

            int[] pa = new int[n + 1];
            int[] pb = new int[m + 1];

            for (int i = 0; i < n; i++) {
                pa[i + 1] = (pa[i] + (a.charAt(i) - '0')) % 10;
            }

            for (int i = 0; i < m; i++) {
                pb[i + 1] = (pb[i] + (b.charAt(i) - '0')) % 10;
            }

            if (pa[n] != pb[m]) {
                out.append(-1).append('\n');
                continue;
            }

            int[][] dp = new int[n + 2][m + 2];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {

                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j]);

                    if (pa[i] == pb[j]) {
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
                    }
                }
            }

            out.append(dp[n + 1][m + 1] - 1).append('\n');
        }

        System.out.print(out);
    }
}