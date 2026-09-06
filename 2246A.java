import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // Read the number of test cases
        String line = br.readLine();
        if (line == null) return;
        st = new StringTokenizer(line);
        int t = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            line = br.readLine();
            if (line == null) break;
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            
            // Generate the permutation [2, 1, 4, 3, 6, 5, ..., n, n-1]
            for (int i = 1; i <= n; i += 2) {
                sb.append(i + 1).append(" ").append(i).append(" ");
            }
            sb.append("\n");
        }
        
        // Print all outputs at once for maximum speed
        System.out.print(sb.toString());
    }
}
