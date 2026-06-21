class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int minValue = nums[0];
        int maxValue = nums[nums.length-1];
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int i=minValue;i<maxValue;i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}