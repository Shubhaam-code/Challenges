import java.util.*;

public class Doremy_Paint_3_1890A {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

            if (map.size() == 1) {
                System.out.println("Yes");
                continue;
            }

            if (map.size() > 2) {
                System.out.println("No");
                continue;
            }

            int f1 = 0, f2 = 0, cnt = 0;

            for (int freq : map.values()) {
                if (cnt == 0)
                    f1 = freq;
                else
                    f2 = freq;
                cnt++;
            }

            if (n % 2 == 0) {
                if (f1 == n / 2 && f2 == n / 2)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            } else {
                if ((f1 == n / 2 + 1 && f2 == n / 2) || (f2 == n / 2 + 1 && f1 == n / 2))
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }

        }
        sc.close();
    }
}