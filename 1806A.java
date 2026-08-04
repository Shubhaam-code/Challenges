import java.util.Scanner;

public class Walking_Master_1806A {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long d = sc.nextLong();

            long up = d - b;

            if (up < 0) {
                System.out.println(-1);
                continue;
            }

            long left = a + up - c;

            if (left < 0) {
                System.out.println(-1);
                continue;
            }

            System.out.println(up + left);
        }
        sc.close();
    }
}