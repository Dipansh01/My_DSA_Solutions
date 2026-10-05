class Solution {
    public int[] rearrangeArray(int[] nums) {
        int positive = 0;
        int negative = 1;
        int[] res = new int[nums.length];
        for(int num : nums){
            if(num > 0){
                res[positive] = num;
                positive += 2;
            }
            else{
                res[negative] = num;
                negative += 2;
            }
        }
        return res;
    }
}