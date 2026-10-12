class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> setRes = new HashSet<>();
        for(int i=0;i<nums.length-1;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int third = -(nums[i] + nums[j]);
                if(!set.isEmpty() && set.contains(third)){
                    ArrayList<Integer> arrList = new ArrayList<>();
                    arrList.add(nums[i]);
                    arrList.add(nums[j]);
                    arrList.add(third);
                    Collections.sort(arrList);
                    setRes.add(arrList);
                }
                set.add(nums[j]);
            }
        }
        for(List<Integer> list : setRes){
            res.add(list);
        }
        return res;
    }
}