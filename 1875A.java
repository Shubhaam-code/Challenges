import java.util.Scanner;

public class Jellyfish_and_Undertale_1875A {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            int n = sc.nextInt();

            long maximumTime = b;

            for (int i = 0; i < n; i++) {
                long x = sc.nextLong();

                maximumTime += Math.min(x, a - 1);
            }

            System.out.println(maximumTime);
        }

        sc.close();
    }
}