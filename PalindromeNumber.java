public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int rev=0,t=x;
        while(x>0){
            int d=x%10;
            rev=(rev*10)+d;
            x=x/10;
        }
        return t==rev;
    }
}
