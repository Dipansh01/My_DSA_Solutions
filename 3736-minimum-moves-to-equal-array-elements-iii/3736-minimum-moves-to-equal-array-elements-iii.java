class Solution {
    public int minMoves(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
            largest = Math.max(largest, nums[i]);
        }
        return (largest * n) - sum;
    }
}