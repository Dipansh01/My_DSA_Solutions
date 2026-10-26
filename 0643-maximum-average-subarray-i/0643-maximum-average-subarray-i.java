class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;
        double currSum = 0;
        int i = 0;
        int j = 0;
        while(j < nums.length){
            currSum += nums[j];
            if(j-i+1 == k){
                maxAvg = Math.max(maxAvg, currSum / k);
                currSum -= nums[i];
                i++;
            }
            j++;
        }
        return maxAvg;
    }
}