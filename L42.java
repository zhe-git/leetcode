//TC:O(n)
//SC:O(1) Only constant space required for left, right, leftMax and rightMax.

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        
        int left = 0, right = height.length - 1;
        int water = 0;
        
        while(left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            
            //firstly, find the higher bar in which side(left or right)
            //then from the lower side add the water
            //if leftMax = height[left], water += 0. if leftMax > height[left], it can contain water.
            if(leftMax < rightMax){
                water += leftMax - height[left];
                left++;
            }
            else{
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}