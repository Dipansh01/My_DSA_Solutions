class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n-1;
        int i = 0;
        int j = n-1;
        while(i<n && j>=0){
            if(nums[i] < pivot){
                res[left] = nums[i];
                left++;
            }
            if(nums[j] > pivot){
                res[right] = nums[j];
                right--;
            }
            i++;
            j--;
        }
        while(left <= right){
            res[left] = pivot;
            left++;
        }
        return res;
    }
}