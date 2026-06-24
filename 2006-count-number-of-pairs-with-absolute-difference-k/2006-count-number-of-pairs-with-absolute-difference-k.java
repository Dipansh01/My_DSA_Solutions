class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                int freq = map.get(num);
                map.put(num,freq+1);
            }
            else{
                map.put(num,1);
            }
        }
        int res = 0;
        for(int i : map.keySet()){
            if(map.containsKey(i-k)){
                res += map.get(i-k) * map.get(i);
            }
            if(map.containsKey(i+k)){
                res += map.get(i+k) * map.get(i);
            }
        }
        return res/2;
    }
}