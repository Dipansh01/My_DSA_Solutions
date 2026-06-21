class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            minValue = Math.min(minValue,num);
            maxValue = Math.max(maxValue,num);
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