class Solution {
    public int findPairs(int[] nums, int k) {
        int res = 0;
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
        for(int i : map.keySet()){
            if(k == 0){
                if(map.get(i)>1){
                    res++;
                }
            }
            else{
                if(map.containsKey(k+i)){
                    res++;
                }
            }
        }
        return res;
    }
}