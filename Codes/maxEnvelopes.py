# class Solution:
# def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
#     if not envelopes:
#         return 0
#     n=len(envelopes)
#     envelopes.sort(key=lambda x: (x[0], -x[1]))
#     dp = [1]*n     
#     for i in range(n):
#         for j in range(i):
#             if envelopes[i][0]>envelopes[j][0] and envelopes[i][1]>envelopes[j][1]:
#                 dp[i]=max(dp[i],dp[j]+1)
#     return max(dp)



class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        n=len(envelopes)
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        tails = []
        for _, h in envelopes:
            idx = bisect_left(tails, h)
            if idx == len(tails):
                tails.append(h)
            else:
                tails[idx] = h

        return len(tails)