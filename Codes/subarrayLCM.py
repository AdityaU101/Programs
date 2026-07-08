from math import gcd

class Solution:
    def subarrayLCM(self, nums: List[int], k: int) -> int:
        def lcm(a: int, b: int) -> int:
            return (a // gcd(a, b)) * b
        n = len(nums)
        ans = 0
        for i in range(n):
            curr_lcm = 1
            for j in range(i, n):
                if k % nums[j] != 0:
                    break
                curr_lcm = lcm(curr_lcm, nums[j])
                if curr_lcm == k:
                    ans += 1
                if curr_lcm > k:
                    break

        return ans