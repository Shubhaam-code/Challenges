class Solution {
  public:
    bool armstrongNumber(int n) {
        int num=n;
        int sum =0;
        while(n!=0){
            int rem=n%10;
            sum=sum+rem*rem*rem;
            n=n/10;
        }
        if(sum==num){
            return true;
        }
        return false;
        
    }
};