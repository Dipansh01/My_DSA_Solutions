class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        int j = n-1;
        int k = n-1;
        while(i <= j){
            int sqi = nums[i] * nums[i];
            int sqj = nums[j] * nums[j];
            if(sqi > sqj){
                res[k] = sqi;
                i++;
                k--;
            }
            else{
                res[k] = sqj;
                j--;
                k--;
            }
        }
        return res;
    }
}