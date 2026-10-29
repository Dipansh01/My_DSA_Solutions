class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while(j < nums.length){
            if(nums[j] == 1){
                j++;
            }
            else{
                if(count < k){
                    count++;
                    j++;
                }
                else{
                    while(nums[i] != 0){
                        i++;
                    }
                    count--;
                    i++;
                }
            }
            maxLen = Math.max(maxLen, j-i);
        }
        return maxLen;
    }
}