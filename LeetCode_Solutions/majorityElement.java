package LeetCode_Solutions;
import java.util.Arrays;

class majorityElement {
    public int MajorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}