public class Shuffle_array {
    public int[] shuffle(int[] nums, int n) {
        int ans[]=new int[2*n];
        for (int i = 0, j = 0; i < n; ++i) {
            ans[j++] = nums[i];
            ans[j++] = nums[i + n];
        }
        return ans;
    }
}
