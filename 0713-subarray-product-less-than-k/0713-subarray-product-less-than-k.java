class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int prod = 1;
            for(int j=i;j<nums.length;j++){
                prod *= nums[j];
                if(prod < k){
                    res++;
                }
                else{
                    break;
                }
            }
        }
        return res;
    }
}