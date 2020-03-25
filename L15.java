// (1) Sort the array - O(nlogn)
// (2) Iterate the array - O(n)
// (3) Find valid triplets - O(n)
// Overall time complexity: O(n^2)
// SC:O(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList();
        
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0) break;
            
            if(i == 0 || (i > 0 && nums[i - 1] != nums[i])){ // Skip duplicated first number
                int target = 0 - nums[i];
                int left = i + 1, right = nums.length -1;

                while(left < right){
                    if(nums[left] + nums[right] == target){
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
						// Skip duplicated second number                    
                        while(left < right && nums[left + 1] == nums[left]){
                        	left++; 
                        } 

                        // Skip duplicated third number
                        while(left < right && nums[right - 1] == nums[right]){
                        	right--; 
                        } 

                        left++;
                        right--;  
                    } 
                    else if(nums[left] + nums[right] < target){
                    	left++;
                    } 
                    else{
                    	right--;
                    } 
                }  
            }
        }
        return res;
    }
}