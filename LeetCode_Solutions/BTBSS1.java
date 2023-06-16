package LeetCode_Solutions;
class BTBSS1 {
    public int maxProfit(int[] prices) {
       int op=0,cp=0,min=prices[0];
       for(int i=1;i<prices.length;i++){
           if(prices[i]<min){
               min=prices[i];
           }
           cp=prices[i]-min;
           if(op<cp){
               op=cp;
           }
       }
       return op;
    }
}
