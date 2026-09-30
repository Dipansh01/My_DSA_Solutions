class Solution {
    static int[] parent;
    static int[] size;

    public int find(int a){
        if(parent[a] == a){
            return a;
        }
        int leader = find(parent[a]);
        parent[a] = leader;
        return leader;
    }

    public void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            if(size[a] > size[b]){
                parent[b] = a;
                size[a] += size[b];
            }
            else{
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        int[] ans = new int[2];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(find(u) == find(v)){
                ans[0] = u;
                ans[1] = v;
                break;
            }
            union(u, v);
        }
        return ans;
    }
}