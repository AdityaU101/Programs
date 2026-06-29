class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return None
        d = ["abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
        ans = [""]

        for i in digits:
            temp = d[int(i)-2]
            ans=[a+b for a in ans for b in temp]
        return ans