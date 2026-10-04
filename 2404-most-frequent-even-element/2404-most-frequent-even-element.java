class Solution {
    public int mostFrequentEven(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums){
            if(num % 2 == 0){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        if(map.isEmpty()){
            return -1;
        }
        int ans = -1;
        int maxFreq = 0;
        for(int key : map.keySet()){
            if(maxFreq < map.get(key)){
                maxFreq = map.get(key);
                ans = key;
            }
        }
        return ans;
    }
}