import java.util.Arrays;

public class MaxProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length-1;
        
        return Math.max(nums[0]*nums[1]*nums[len], nums[len] * nums[len-1] * nums[len-2]);
    }
}
