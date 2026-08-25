import java.io.*;
import java.util.*;

public class Main {

    static int inversionParity(String s) {
        int ones = 0;
        int parity = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else {
                // Every previous 1 forms an inversion with this 0
                parity ^= (ones & 1);
            }
        }

        return parity;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            String a = br.readLine();
            String b = br.readLine();

            // Number of 0s and 1s must be same
            if (!haveSameCount(a, b)) {
                System.out.println("NO");
                continue;
            }

            // Inversion parity must be same
            if (inversionParity(a) == inversionParity(b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean haveSameCount(String a, String b) {

        int countZeroA = 0;
        int countZeroB = 0;

        for (char c : a.toCharArray()) {
            if (c == '0') {
                countZeroA++;
            }
        }

        for (char c : b.toCharArray()) {
            if (c == '0') {
                countZeroB++;
            }
        }

        return countZeroA == countZeroB;
    }
}