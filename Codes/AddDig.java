public class AddDig {
    int sod(int n){
        int sum=0;
        while(n!=0){
            int d=n%10;
            sum+=d;
            n=n/10;
        }
        return sum;
    }
    public int addDigits(int num) {
        int x=num;
        while(sod(x)>=10){
            x=sod(x);
        }
        return sod(x);
    }
}
