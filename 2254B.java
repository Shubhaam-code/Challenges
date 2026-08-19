import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            // Original compressed length
            int compressed = 1;

            for (int i = 1; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    compressed++;
                }
            }

            int answer = compressed;

            // Delete exactly one character
            // Cannot delete first or last
            for (int i = 1; i < n - 1; i++) {

                char left = s.charAt(i - 1);
                char cur = s.charAt(i);
                char right = s.charAt(i + 1);

                int oldTransitions = 0;

                if (left != cur) {
                    oldTransitions++;
                }

                if (cur != right) {
                    oldTransitions++;
                }

                int newTransitions = (left != right) ? 1 : 0;

                int newCompressed =
                        compressed - oldTransitions + newTransitions;

                answer = Math.min(answer, newCompressed);
            }

            System.out.println(answer);
        }

        sc.close();
    }
}