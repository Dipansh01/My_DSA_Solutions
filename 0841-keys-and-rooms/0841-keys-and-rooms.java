class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        dfs(rooms, vis, 0);
        for(boolean bool : vis){
            if(bool == false){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms, boolean[] vis, int st){
        vis[st] = true;
        for(int room : rooms.get(st)){
            if(!vis[room]){
                dfs(rooms, vis, room);
            }
        }
    }
}