import java.util.Scanner;

public class Cover_in_Water_1900A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int dots = 0;
            boolean found = false;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '.') dots++;
            }

            for (int i = 0; i + 2 < n; i++) {
                if (s.charAt(i) == '.'
                        && s.charAt(i + 1) == '.'
                        && s.charAt(i + 2) == '.') {
                    found = true;
                    break;
                }
            }

            if (found)
                System.out.println(2);
            else
                System.out.println(dots);
        }
        sc.close();
    }
}