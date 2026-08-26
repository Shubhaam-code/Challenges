import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            String a = sc.next();
            String b = sc.next();

            int oddA = 0;
            int evenA = 0;

            int oddB = 0;
            int evenB = 0;

            for (int i = 0; i < n; i++) {

                // i = 0 means actual position 1 (odd)
                if (i % 2 == 0) {

                    if (a.charAt(i) == '1')
                        oddA++;

                    if (b.charAt(i) == '1')
                        oddB++;

                } else {

                    if (a.charAt(i) == '1')
                        evenA++;

                    if (b.charAt(i) == '1')
                        evenB++;
                }
            }

            if (oddA == oddB && evenA == evenB) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}