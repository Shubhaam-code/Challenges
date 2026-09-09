import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        if (!br.ready()) return; 
        st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        StringBuilder output = new StringBuilder();
        
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            String s = br.readLine();
            int totalCost = 0;
            
            for (int i = 0; i < n; i += k) {
                boolean hasZero = false;
                
                for (int j = i; j < i + k; j++) {
                    if (s.charAt(j) == '0') {
                        hasZero = true;
                        break;
                    }
                }
                
                if (!hasZero) {
                    totalCost++;
                }
            }
            
            output.append(totalCost).append("\n");
        }
        
        System.out.print(output);
    }
}
