import java.util.Arrays;

public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1]) return true;
        }
        return false;
    }
}
/*public boolean containsDuplicate(int[] nums) {
        
        
        Set<Integer> memo = new HashSet<>();
        
        for (int el : nums) {
            
            
            if (memo.contains(el)) {
                return true;
            }
            
            memo.add(el);
            
            
        }
        
        return false;
        
    }
*/