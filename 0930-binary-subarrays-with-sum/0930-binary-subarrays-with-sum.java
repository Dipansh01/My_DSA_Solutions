class Solution {
    public int helper(int[] nums, int goal){
        if(goal < 0){
            return 0;
        }
        int sum = 0;
        int res = 0;
        int i = 0;
        int j = 0;
        while(j < nums.length){
            sum += nums[j];
            while(sum > goal){
                sum -= nums[i];
                i++;
            }
            res += j-i+1;
            j++;
        }
        return res;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal-1);
    }
}