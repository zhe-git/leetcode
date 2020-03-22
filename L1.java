//TC:O(n)  We traverse the list containing nn elements only once. Each look up in the table costs only O(1) time.
//SC:O(n)  The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int res = target - nums[i];
            if(map.containsKey(res)){
                return new int[]{map.get(res), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
