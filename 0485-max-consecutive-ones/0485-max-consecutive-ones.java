class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int i = 0;
        int j = 0;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                if(nums[j] == 0){
                    i++;
                }
                j++;
            }
            else{
                res = Math.max(res, j-i);
                i = j;
            }
        }
        res = Math.max(res, j-i);
        return res;
    }
}