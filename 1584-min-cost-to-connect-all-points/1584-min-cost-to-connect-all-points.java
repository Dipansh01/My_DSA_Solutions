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

    public class Triplet {
        int u;
        int v;
        int dis;
        Triplet(int u, int v, int dis){
            this.u = u;
            this.v = v;
            this.dis = dis;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.dis, b.dis));
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dis = Math.abs(x1-x2) + Math.abs(y1-y2);
                pq.add(new Triplet(i, j, dis));
            }
        }
        int minCost = 0;
        while(!pq.isEmpty()){
            Triplet top = pq.remove();
            int u = top.u;
            int v = top.v;
            int dis = top.dis;
            if(find(u) != find(v)){
                minCost += dis;
                union(u,v);
            }
        }
        return minCost;
    }
}