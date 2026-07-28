import java.util.*;
public class Desorting_1853A {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            boolean bad = false;

            // Check if already unsorted
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    bad = true;
                    break;
                }
            }

            if (bad) {
                System.out.println(0);
                continue;
            }

            int minDiff = Integer.MAX_VALUE;

            // Find minimum adjacent difference
            for (int i = 1; i < n; i++) {
                minDiff = Math.min(minDiff, a[i] - a[i - 1]);
            }

            System.out.println(minDiff / 2 + 1);
        }

        sc.close();
    }
}