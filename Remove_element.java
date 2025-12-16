public class Remove_element {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0; 
        int j = 0; 

        while(j < nums.length) {
            while(j < nums.length && nums[j] == val) {
                j++;
            }

            
            if(j < nums.length) {
                nums[i] = nums[j];

                i++;
                j++;
            }
        }

        return i;

    }
}
