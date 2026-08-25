import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int current = 0;
            int maxLen = 0;

            for (char ch : s.toCharArray()) {
                if (ch == '#') {
                    current++;
                    maxLen = Math.max(maxLen, current);
                } else {
                    current = 0;
                }
            }

            System.out.println((maxLen + 1) / 2);
        }

        sc.close();
    }
}