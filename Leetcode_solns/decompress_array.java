public class decompress_array {
    public int[] decompressRLElist(int[] nums) {
        int n=0;
        for (int i = 0; i < nums.length; i += 2) {
            n += nums[i];
        }
        int ans[] = new int[n];
        int k=0;
        for(int i=0,j=1;j<nums.length;i+=2,j+=2){
            for (int j2 = 0; j2 < nums[i]; j2++) {
                ans[k++]=nums[j];
            }
        }
        return ans;
    }
}
