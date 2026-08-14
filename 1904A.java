import java.util.*;
public class  Forked1904A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            long xK = sc.nextLong();
            long yK = sc.nextLong();

            long xQ = sc.nextLong();
            long yQ = sc.nextLong();

            Set<String> king = new HashSet<>();
            Set<String> queen = new HashSet<>();

            long[][] moves = {
                {a, b},
                {a, -b},
                {-a, b},
                {-a, -b},
                {b, a},
                {b, -a},
                {-b, a},
                {-b, -a}
            };

            // Positions from which knight can attack King
            for (long[] move : moves) {
                long x = xK + move[0];
                long y = yK + move[1];

                king.add(x + "," + y);
            }

            // Positions from which knight can attack Queen
            for (long[] move : moves) {
                long x = xQ + move[0];
                long y = yQ + move[1];

                queen.add(x + "," + y);
            }

            int ans = 0;

            for (String pos : king) {
                if (queen.contains(pos)) {
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }
}