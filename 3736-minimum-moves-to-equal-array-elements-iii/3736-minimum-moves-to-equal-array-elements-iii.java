class Solution {
    public int minMoves(int[] nums) {
        int largest = nums[0];
        for(int num : nums){
            largest = Math.max(largest, num);
        }
        int moves = 0;
        for(int num : nums){
            moves += largest - num;
        }
        return moves;
    }
}