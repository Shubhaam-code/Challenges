import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();

            // Delete first 0
            int firstZero = s.indexOf('0');
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(firstZero);

            // Delete first 1
            int firstOne = sb.indexOf("1");
            sb.deleteCharAt(firstOne);

            System.out.println(sb.toString());
        }
    }
}