import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Make_It_Zero_1869A {
     public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            // We don't actually need the array values.
            StringTokenizer st = new StringTokenizer(br.readLine());

            // Consume all n elements
            for (int i = 0; i < n; i++) {
                st.nextToken();
            }

            if (n % 2 == 0) {

                // Even length:
                // Apply the whole array twice.
                out.append(2).append('\n');

                out.append(1).append(' ').append(n).append('\n');
                out.append(1).append(' ').append(n).append('\n');

            } else {

                // Odd length:
                // First n-1 elements form an even-length segment.
                // Then last two elements form an even-length segment.
                out.append(4).append('\n');

                out.append(1).append(' ').append(n - 1).append('\n');
                out.append(1).append(' ').append(n - 1).append('\n');

                out.append(n - 1).append(' ').append(n).append('\n');
                out.append(n - 1).append(' ').append(n).append('\n');
            }
        }

        System.out.print(out);
    }
}