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
        if(size[a] > size[b]){
            parent[b] = a;
            size[a] += size[b];
        }
        else{
            parent[a] = b;
            size[b] += size[a];
        }
    }

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        int extraEdge = 0;
        for(int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(find(u) == find(v)){
                extraEdge++;
            }
            else{
                union(u,v);
            }
        }
        int comp = 0;
        for(int i=0;i<n;i++){
            if(parent[i] == i){
                comp++;
            }
        }
        if(extraEdge >= comp-1){
            return comp-1;
        }
        return -1;
    }
}