class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        for(int key : map.keySet()){
            int freq = map.get(key);
            pq.add(new int[]{freq,key});
            if(pq.size() > k){
                pq.remove();
            }
        }
        int[] ans = new int[k];
        int i = k-1;
        while(!pq.isEmpty()){
            ans[i] = pq.remove()[1];
            i--;
        }
        return ans;
    }
}