class Solution {
    public int minMoves(int[] nums) {
        int largest = nums[0];
        int sum = 0;
        for(int num : nums){
            sum += num;
            largest = Math.max(largest, num);
        }
        return (largest * nums.length) - sum;
    }
}