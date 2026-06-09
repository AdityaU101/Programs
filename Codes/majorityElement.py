#Solution 1 
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n=len(nums)
        nums.sort()
        count,maxcount=0,0
        maj=nums[0]
        for i in range(1,len(nums)):
            if nums[i]==nums[i-1]:
                count+=1
                if count>maxcount:
                    maj = nums[i]
            else:
                count=0
            maxcount = max(maxcount,count)
        return maj

#Solution 2

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n=len(nums)
        nums.sort()
        return nums[n//2]
