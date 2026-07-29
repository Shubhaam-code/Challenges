import java.util.*;

public class Bigrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int k = sc.nextInt();

            boolean possible = false;
            int countTwo = 0;

            for (int i = 0; i < k; i++) {
                long c = sc.nextLong();

                if (c >= 3) {
                    possible = true;
                }

                if (c >= 2) {
                    countTwo++;
                }
            }

            if (possible || countTwo >= 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}