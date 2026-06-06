class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        
        n=len(nums)
        k=0
        i=0
        j=n-1
        
        while i<=j:
            if nums[i]==val:
                nums[i]=nums[j]
                j-=1
            else:
                i+=1
                k+=1
        return k
