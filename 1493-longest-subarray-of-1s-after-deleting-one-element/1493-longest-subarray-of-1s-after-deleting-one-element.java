class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0;
        int zeroIndex = -1;
        int i = 0;
        int j = 0;
        int n = nums.length;
        while(j < n){
            if(nums[j] == 0){
                i = zeroIndex + 1;
                zeroIndex = j;
            }
            res = Math.max(res, j-i);
            j++;
        }
        if(zeroIndex == -1){
            return n-1;
        }
        return res;
    }
}