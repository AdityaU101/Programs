from collections import Counter
class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        freq=Counter(arr)
        count=0
        if k>len(freq):
            return ""
        for a in arr:
            if freq[a]==1:
                count+=1
                if count==k:
                    return a
        return ""
                