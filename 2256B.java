import java.io.*;
import java.util.*;

public class Main {

    static final long MOD = 998244353L;

    static long countChain(String s, int start) {
        int ways = 0;

        // Starting value can be 0 or 1
        for (int first = 0; first <= 1; first++) {
            boolean ok = true;

            for (int i = start; i < s.length(); i += 2) {
                int pos = (i - start) / 2;

                // Values must alternate
                int expected = first ^ (pos & 1);

                if (s.charAt(i) != '?' &&
                    s.charAt(i) - '0' != expected) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                ways++;
            }
        }

        return ways;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            // Positions 0,2,4,... 
            long oddWays = countChain(s, 0);

            // Positions 1,3,5,...
            long evenWays = countChain(s, 1);

            long answer = (oddWays * evenWays) % MOD;

            System.out.println(answer);
        }
    }
}