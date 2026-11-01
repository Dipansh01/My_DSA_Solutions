class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, sum = 0, res = Integer.MAX_VALUE;
        while(j < nums.length){
            sum += nums[j];
            while(sum >= target){
                res = Math.min(res, j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        if(res == Integer.MAX_VALUE){
            return 0;
        }
        return res;
    }
}