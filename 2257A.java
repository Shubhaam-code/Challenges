import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            boolean[] available = new boolean[26];

            // Initial words ke first letters
            for (int i = 0; i < n; i++) {
                String word = sc.next();
                char c = Character.toUpperCase(word.charAt(0));
                available[c - 'A'] = true;
            }

            String[] abbreviations = new String[m];

            for (int i = 0; i < m; i++) {
                abbreviations[i] = sc.next();
            }

            boolean[] used = new boolean[m];
            int created = 0;
            boolean possible = true;

            // Jab tak koi naya abbreviation create ho sakta hai
            while (created < m) {

                boolean found = false;

                for (int i = 0; i < m; i++) {

                    if (used[i])
                        continue;

                    String s = abbreviations[i];

                    boolean canCreate = true;

                    // Check karo is abbreviation ke
                    // saare letters available hain ya nahi
                    for (char c : s.toCharArray()) {
                        if (!available[c - 'A']) {
                            canCreate = false;
                            break;
                        }
                    }

                    if (canCreate) {
                        used[i] = true;
                        created++;

                        // Ye abbreviation ab ek word ban gaya
                        // Iska first letter future me available hai
                        available[s.charAt(0) - 'A'] = true;

                        found = true;
                    }
                }

                // Ek bhi naya abbreviation nahi bana
                if (!found) {
                    possible = false;
                    break;
                }
            }

            System.out.println(possible ? "YES" : "NO");
        }

        sc.close();
    }
}