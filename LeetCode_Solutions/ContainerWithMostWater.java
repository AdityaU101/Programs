package LeetCode_Solutions;
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1,res=0;
        while(l<r){
            int area=(r-l)*Math.min(height[l], height[r]);
            res=Math.max(area, res);
            if(height[l]<height[r]) l++;
            else r--; 
        }
        return res;   
    }
}
