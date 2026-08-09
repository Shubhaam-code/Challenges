import java.util.Scanner;

public class Make_it_Beautiful_1783A {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // If all elements are same, impossible
            if (a[0] == a[n - 1]) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");

            // Put maximum element first
            System.out.print(a[n - 1] + " ");

            // Print remaining elements
            for (int i = 0; i < n - 1; i++) {
                System.out.print(a[i] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}