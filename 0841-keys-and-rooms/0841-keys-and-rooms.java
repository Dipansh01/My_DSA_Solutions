class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        bfs(rooms, vis, 0);
        for(boolean room : vis){
            if(!room){
                return false;
            }
        }
        return true;
    }
    public void bfs(List<List<Integer>> rooms, boolean[] vis, int st){
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        while(!q.isEmpty()){
            int front = q.remove();
            for(int ele : rooms.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }
    }
}