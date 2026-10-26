class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while(j < nums.length){
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                currSum -= nums[i];
                i++;
            }
            currSum += nums[j];
            set.add(nums[j]);
            if(j-i+1 == k){
                maxSum = Math.max(maxSum, currSum);
                currSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            j++;
        }
        return maxSum;
    }
}