public class SortColors {

    public void sortColors(int[] nums) {
        int p=0;
        int t[]=new int[nums.length];
        for(int i=0;i<3;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j]==i){
                    t[p]=i;
                    p++;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=t[i];
        }
    }
}

