import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            sb.append(solve(n, s)).append("\n");
        }
        System.out.print(sb);
    }
    
    private static int solve(int n, String s) {
        int total0 = 0, total1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') total0++;
            else total1++;
        }
        
        // State variables tracking the max length of a valid alternating subsequence
        // sX_endY represents: starts with X, ends with Y
        int s0_end0 = -100000000;
        int s0_end1 = -100000000;
        int s1_end0 = -100000000;
        int s1_end1 = -100000000;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                s0_end0 = Math.max(s0_end0, Math.max(1, s0_end1 + 1));
                s1_end0 = Math.max(s1_end0, s1_end1 + 1);
            } else {
                s0_end1 = Math.max(s0_end1, s0_end0 + 1);
                s1_end1 = Math.max(s1_end1, Math.max(1, s1_end0 + 1));
            }
        }
        
        int minDeletions = Integer.MAX_VALUE;
        
        // Configuration 1: Starts with 0, Ends with 0
        if (s0_end0 > 0) {
            int rem0 = (s0_end0 + 1) / 2;
            int rem1 = s0_end0 - rem0;
            if (Math.abs((total0 - rem0) - (total1 - rem1)) <= 1) {
                minDeletions = Math.min(minDeletions, n - s0_end0);
            }
        }
        
        // Configuration 2: Starts with 0, Ends with 1
        if (s0_end1 > 0) {
            int rem0 = s0_end1 / 2;
            int rem1 = s0_end1 / 2;
            if (Math.abs((total0 - rem0) - (total1 - rem1)) <= 1) {
                minDeletions = Math.min(minDeletions, n - s0_end1);
            }
        }
        
        // Configuration 3: Starts with 1, Ends with 0
        if (s1_end0 > 0) {
            int rem0 = s1_end0 / 2;
            int rem1 = s1_end0 / 2;
            if (Math.abs((total0 - rem0) - (total1 - rem1)) <= 1) {
                minDeletions = Math.min(minDeletions, n - s1_end0);
            }
        }
        
        // Configuration 4: Starts with 1, Ends with 1
        if (s1_end1 > 0) {
            int rem1 = (s1_end1 + 1) / 2;
            int rem0 = s1_end1 - rem1;
            if (Math.abs((total0 - rem0) - (total1 - rem1)) <= 1) {
                minDeletions = Math.min(minDeletions, n - s1_end1);
            }
        }
        
        return (minDeletions == Integer.MAX_VALUE) ? -1 : minDeletions;
    }
}
2259B