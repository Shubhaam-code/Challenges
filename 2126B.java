/*
 * Problem: 2126B - No Casino in the Mountains
 * URL: https://codeforces.com/problemset/problem/2126/B
 */

import java.util.Scanner;

public class CF2126B_No_Casino_in_the_Mountains {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int count = 0;
            int consecutive = 0;

            for (int i = 0; i < n; i++) {

                if (arr[i] == 0) {
                    consecutive++;
                } else {
                    consecutive = 0;
                }

                // We found k consecutive safe days
                if (consecutive == k) {

                    count++;

                    // The next day cannot be used for another hike
                    i++;

                    // Reset consecutive count
                    consecutive = 0;
                }
            }

            System.out.println(count);
        }

        sc.close();
    }
}