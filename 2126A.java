import java.util.Scanner;

public class CF2126B_No_Casino_in_the_Mountains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int count = 0;
            int i = 0;
            while (i <= n - k) {
                boolean canHike = true;
                for (int j = i; j < i + k; j++) {
                    if (arr[j] == 1) {
                        canHike = false;
                        break;
                    }
                }
                if (canHike) {
                    count++;
                    i += k + 1;
                } else {
                    i++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}