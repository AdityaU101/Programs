import java.util.Arrays;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if(nums.length>=3)return nums[2];
        return nums[0];
    }
}
