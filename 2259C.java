import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] a = new int[n];

            boolean hasOne = false;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                if (a[i] == 1) {
                    hasOne = true;
                }
            }

            if (!hasOne) {

                // No 1 exists.
                // Put 1 at both ends if possible.

                a[0] = 1;

                if (n > 1) {
                    a[n - 1] = 1;
                }

            } else {

                // At least one 1 exists.
                // Replace all -1 with 0.

                for (int i = 0; i < n; i++) {

                    if (a[i] == -1) {
                        a[i] = 0;
                    }
                }
            }

            // Print answer

            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}