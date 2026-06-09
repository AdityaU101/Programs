class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums)<=2:
            return len(nums)
        n = len(nums)-1
        i,k=2,2

        while i<=n:
            if nums[i]!=nums[k-2]:
                nums[k]=nums[i]
                k+=1
            i+=1
        return k