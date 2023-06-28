class MoveZeros {
    public void moveZeroes(int[] nums) {
        int p=0;
        for(int i:nums){
            if(i!=0){
                nums[p++]=i;
            }
        }
        for(int i=p;i<nums.length;i++){
            nums[i]=0;
        }
    }
}