class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for(int num : nums){
            set.add(num);
        }
        for(int i=1;i<n+1;i++){
            if(!set.contains(i)){
                res = i;
                break;
            }
        }
        if(res == 0){
            return n+1;
        }
        return res;
    }
}