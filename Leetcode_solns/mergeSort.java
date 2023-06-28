import java.util.ArrayList;

public class mergeSort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> res= new ArrayList<Integer>();
        for(int i=0;i<m;i++){
            res.add(nums1[i]);
        }
        for(int i=0;i<n;i++){
            res.add(nums2[i]);
        }
        res.sort(null);
        for(int i=0;i<res.size();i++){
            nums1[i]=res.get(i);
        }
    }
} 
