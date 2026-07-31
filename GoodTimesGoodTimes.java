import java.util.*;

public class GoodTimesGoodTimes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int x = sc.nextInt();

            int y = 1;

            while (x > 0) {
                y *= 10;
                x /= 10;
            }

            System.out.println(y + 1);
        }
    }
}