public class smaller_num_than_curr {
    public int counter(int n, int[] a) {
        int count = 0;
        for (int i : a) {
            if (i < n)
                count++;
        }
        return count;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = counter(nums[i], nums);
        }
        return ans;
    }
}
