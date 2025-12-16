import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Intersection_array1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> n1=new ArrayList<>();
        Set<Integer> n2=new HashSet<>();
        int j=0;
        for(int i:nums1){
            n1.add(i);
        }
        for(int i:nums2){
            if(n1.contains(i) && !n2.contains(i)){
                n2.add(i);
            }
        }
        int[] res=new int[n2.size()];
        for(int i:n2){
            res[j++]=i;
        }
        return res;
    }
}
/*
 * public int[] intersection(int[] nums1, int[] nums2) {
        public int[] intersect(int[] nums1, int[] nums2) {

            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int p1 = 0;
            int p2 = 0;

            ArrayList<Integer> list = new ArrayList<>();

            while (p1 < nums1.length && p2 < nums2.length) {
                int val1 = nums1[p1];
                int val2 = nums2[p2];

                if (val1 == val2) {
                    list.add(val1);
                    p1++;
                    p2++;
                } else if (val1 < val2) {
                    p1++;
                } else {
                    p2++;
                }
            }

//            int[] result = new int[list.size()];
//            int i = 0;
//            while (i < list.size()){
//                result[i] = list.get(i);
//                i++;
//            }

            int[] result = list.stream().mapToInt(Integer::intValue).toArray();

            return result;

        }

    }
 */