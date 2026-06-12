class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n=len(prices)
        prof=0
        for i in range(1,n):
            if prices[i]>prices[i-1]:
                prof+=prices[i]-prices[i-1]
        return prof