import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];
            int totalTwos = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                if (a[i] == 2) {
                    totalTwos++;
                }
            }

            // Odd number of 2s -> impossible
            if (totalTwos % 2 != 0) {
                System.out.println(-1);
                continue;
            }

            int needed = totalTwos / 2;
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] == 2) {
                    count++;
                }

                if (count == needed) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }

        sc.close();
    }
}