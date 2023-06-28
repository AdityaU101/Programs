class Array_concat{
    public int[] getConcatenation(int[] nums) {
        int n=2*nums.length;
        int ans[] = new int[n];
        for(int i=0;i<nums.length;i++){
            ans[i]=ans[nums.length+i]=nums[i];
        }
        return ans;
    }
}