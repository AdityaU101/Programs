public class CountingBits {
    public int c1(int n){
        int count=0;
        while(n!=0){
            int x=n&1;
            if(x==1) count++;
            n=n>>1;
        }
        return count;
    }
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=c1(i);
        }
        return ans;
    }
}

