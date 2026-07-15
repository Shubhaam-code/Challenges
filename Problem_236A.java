import java.util.HashSet;
import java.util.Scanner;
public class Problem_236A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashSet<Character> chars = new HashSet<>();
        for(char c: input.toCharArray()) {
            chars.add(c) ;
        }
        if(chars.size()%2 == 0){
            System.out.println("CHAT WITH HER!");
        } else{
            System.out.println("IGNORE HIM!");
        }
        scanner.close();
    }
}