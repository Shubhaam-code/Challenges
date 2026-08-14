import java.util.Scanner;

public class Extremely_Round_1766A {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            String s = String.valueOf(n);

            int digits = s.length();
            int firstDigit = s.charAt(0) - '0';

            int answer = (digits - 1) * 9 + firstDigit;

            System.out.println(answer);
        }
        sc.close() ;
    }
}