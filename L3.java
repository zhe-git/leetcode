//TC: O(N)      i will iterate n times
//SC: O(min(m,n))

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        
        //Sliding Window. j is the start, i is the end.
        for(int i = 0, j = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(map.get(s.charAt(i)), j);
            }
            res = Math.max(res, i - j + 1);
            map.put(s.charAt(i), i + 1);
        }        
        return res;      
    }
}