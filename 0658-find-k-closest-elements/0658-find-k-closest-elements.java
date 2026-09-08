class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0],a[0]));
        for(int num : arr){
            int diff = Math.abs(x-num);
            if(pq.size() < k){
                pq.add(new int[]{diff,num});
            }
            else{
                if(pq.peek()[0] > diff){
                    pq.remove();
                    pq.add(new int[]{diff,num});
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] curr : pq){
            ans.add(curr[1]);
        }
        Collections.sort(ans);
        return ans;
    }
}