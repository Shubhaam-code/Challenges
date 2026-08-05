import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            if (n == 1) {
                System.out.println(1);
            } else if (n == 2) {
                System.out.println(-1);
            } else {
                ArrayList<Long> ans = new ArrayList<>();

                ans.add(1L);
                ans.add(2L);
                ans.add(3L);

                long sum = 6;

                while (ans.size() < n) {
                    ans.add(sum);
                    sum *= 2;
                }

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print(ans.get(i));
                    if (i + 1 < ans.size())
                        System.out.print(" ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}