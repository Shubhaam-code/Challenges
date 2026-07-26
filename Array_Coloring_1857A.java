import java.util.* ;
public class Array_Coloring_1857A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int num[] = new int[n] ;
            for(int i = 0 ; i<n;i++){
                num[i] = sc.nextInt();
            }
            int countodd = 0 ;

            for(int i = 0 ; i<n ; i++){
                if(num[i]%2 != 0) countodd++ ;
            } 

           if(countodd%2 == 0 ){
            System.out.println("Yes");
           }
           else{
            System.out.println("No");
           }
        }

        sc.close();
    }
}