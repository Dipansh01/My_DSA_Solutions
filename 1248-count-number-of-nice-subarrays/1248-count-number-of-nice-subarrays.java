class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        int prevCount = 0;
        int res = 0;
        while(j < nums.length){
            if(nums[j] % 2 != 0){
                count++;
                prevCount = 0;
            }
            while(count == k){
                prevCount++;
                if(nums[i] % 2 != 0){
                    count--;
                }
                i++;
            }
            res += prevCount;
            j++;
        }
        return res;
    }
}