class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int zero = 0;
        int prod = 1;
        for(int num : nums){
            if(num != 0){
                prod = prod * num;
            }
            else{
                zero++;
            }
        }
        int[] res = new int[n];
        int i = 0;
        for(int num : nums){
            if(zero == 0){
                res[i] = prod / num;
            }
            else if(zero == 1){
                if(num == 0){
                    res[i] = prod;
                }
                else{
                    res[i] = 0;
                }
            }
            else{
                res[i] = 0;
            }
            i++;
        }
        return res;
    }
}