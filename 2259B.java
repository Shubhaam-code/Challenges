import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // Read number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            
            int oddCount = 0;
            int evenMod4_0 = 0; // Remainder 0 when divided by 4
            int evenMod4_2 = 0; // Remainder 2 when divided by 4

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());
                
                if (a % 2 != 0) {
                    oddCount++;
                } else {
                    if (a % 4 == 0) {
                        evenMod4_0++;
                    } else {
                        evenMod4_2++;
                    }
                }
            }

            // Find the maximum among the three independent groups
            int maxFrequency = Math.max(oddCount, Math.max(evenMod4_0, evenMod4_2));
            sb.append(maxFrequency).append("\n");
        }

        // Print all outputs at once
        System.out.print(sb);
    }
}
