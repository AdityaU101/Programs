class Solution:
    def findMin(self, nums: List[int]) -> int:
        l=0
        r=len(nums)-1
        small=nums[0]

        while l<r:
            mid=(l+r)//2
            small=min(small,nums[mid])            
            if nums[mid]>=nums[r]:
                l=mid+1
                small=min(small,nums[l])
            else:
                r=mid-1
                small=min(small,nums[r])
        
        return small
