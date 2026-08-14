import java.util.Scanner;

public class Chemistry1883B {
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long tt = sc.nextLong();

        while (tt-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            String s = sc.next();

            int[] frequencyOfCharacters = new int[26];

            for (int i = 0; i < n; i++) {
                frequencyOfCharacters[s.charAt(i) - 'a']++;
            }

            long oddFrequency = 0;

            for (int i = 0; i < 26; i++) {
                oddFrequency += frequencyOfCharacters[i] % 2;
            }

            if (oddFrequency > k + 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

        sc.close();
    }
}