class BTBSS2 {
    public int maxProfit(int[] prices) {
        int sum=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                sum=sum+(prices[i+1]-prices[i]);
            }
        }
        return sum;
    }
}
/*in the for loop: sum+=Math.max(0,prices[i+1]-prices[i])*/
