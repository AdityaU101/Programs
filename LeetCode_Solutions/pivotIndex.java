package LeetCode_Solutions;
class pivotIndex {
    public int PivotIndex(int[] nums) {
        int s=0,ls=0;
        for(int i:nums) s+=i;
        for(int i=0;i<nums.length;++i){
            if(ls==s-ls-nums[i]) return i;
            ls+=nums[i];
        }
        return -1; 
    }
}
