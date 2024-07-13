public class range_sum {
    private int[] s;

    public void NumArray(int[] nums) {
        int n = nums.length;
        s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
    }
    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }
}
