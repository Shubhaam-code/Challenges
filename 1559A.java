import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            int n = sc.nextInt();

            long totalAnd = sc.nextLong();

            for (int i = 1; i < n; i++) {
                long x = sc.nextLong();
                totalAnd &= x;
            }

            System.out.println(totalAnd);
        }

        sc.close();
    }
}