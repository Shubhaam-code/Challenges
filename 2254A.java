import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int rounds = 0;

            while (a != b && b != c && a != c) {

                int min = Math.min(a, Math.min(b, c));
                int max = Math.max(a, Math.max(b, c));

                // Maximum gives 1 token
                if (a == max) {
                    a--;
                } else if (b == max) {
                    b--;
                } else {
                    c--;
                }

                // Minimum receives 1 token
                if (a == min) {
                    a++;
                } else if (b == min) {
                    b++;
                } else {
                    c++;
                }

                rounds++;
            }

            System.out.println(rounds);
        }

        sc.close();
    }
}