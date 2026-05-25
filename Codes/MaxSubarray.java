public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int res=Integer.MIN_VALUE,sum=0;
        for (int i : nums) {
            sum=Math.max(sum+i, i);
            res=Math.max(res, sum);
        }
        return res;
    }
}
