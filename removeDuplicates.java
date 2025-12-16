import java.util.ArrayList;

public class removeDuplicates {
    public int removDuplicates(int[] nums) {
        ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++) {
			if(a.contains(nums[i])==false) a.add(nums[i]);
		}
		for(int i=0;i<a.size();i++) nums[i]=a.get(i);
        return a.size();
    }
}

    