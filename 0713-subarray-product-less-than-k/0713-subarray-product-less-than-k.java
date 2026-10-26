class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int res = 0;
        int product = 1;
        int i = 0;
        for(int j=0;j<nums.length;j++){
            product *= nums[j];
            while(product >= k){
                product /= nums[i];
                i++;
            }
            res += j-i+1;
        }
        return res;
    }
}