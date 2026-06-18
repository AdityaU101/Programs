class Solution:
    def intToRoman(self, num: int) -> str:
        # basically you take the content from nums and then you subtract it from the count of num everytime you get a value lesser than it in a list which is basically a zip of both the value and character associated with we can get the the final answer. 

        c=['M', 'CM', 'D', 'CD', 'C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I']
        v=[1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        ans = []

        for cc,vc in zip(c,v):
            while num>=vc:
                num-=vc
                ans.append(cc)
        
        return "".join(ans)