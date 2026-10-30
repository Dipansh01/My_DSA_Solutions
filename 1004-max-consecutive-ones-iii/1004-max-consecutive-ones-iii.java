class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while(j < nums.length){
            if(nums[j] == 0){
                count++;
            }
            while(count > k){
                if(nums[i] == 0){
                    count--;
                }
                i++;
            }
            j++;
            maxLen = Math.max(maxLen, j-i);
        }
        return maxLen;
    }
}