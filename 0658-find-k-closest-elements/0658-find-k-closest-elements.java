class Pair {
    int dis;
    int val;

    Pair(int dis, int val){
        this.dis = dis;
        this.val = val;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.dis, a.dis));
        for(int num : arr){
            if(pq.size() < k){
                pq.add(new Pair(Math.abs(x-num),num));
            }
            else{
                Pair top = pq.peek();
                if(top.dis == Math.abs(x-num)){
                    if(top.val > num){
                        pq.remove();
                        pq.add(new Pair(Math.abs(x-num),num));
                    }
                }
                else if(top.dis > Math.abs(x-num)){
                    pq.remove();
                    pq.add(new Pair(Math.abs(x-num),num));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(pq.size() > 0){
            Pair p = pq.remove();
            ans.add(p.val);
        }
        Collections.sort(ans);
        return ans;
    }
}