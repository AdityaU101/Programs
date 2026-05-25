import java.util.Arrays;

class MissingNumber{
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums[0]==1) return 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]+1!=nums[i+1]) return nums[i]+1;
        }
        return nums[nums.length-1]+1;
    }
}
/*class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}*/
