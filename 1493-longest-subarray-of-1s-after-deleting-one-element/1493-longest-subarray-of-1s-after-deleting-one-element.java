class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0;
        int zeroCount = 0;
        int i = 0;
        int j = 0;
        int n = nums.length;
        while(j < n){
            if(nums[j] == 0){
                zeroCount++;
            }
            while(zeroCount > 1){
                if(nums[i] == 0){
                    zeroCount--;
                }
                i++;
            }
            res = Math.max(res, j-i);
            j++;
        }
        if(zeroCount == 0){
            return n-1;
        }
        return res;
    }
}