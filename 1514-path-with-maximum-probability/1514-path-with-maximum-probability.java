class Pair {
    int node;
    double prob;
    Pair(int node, double prob){
        this.node = node;
        this.prob = prob;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        double[] probabilities = new double[n];
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
            probabilities[i] = -1.0;
        }
        probabilities[start_node] = 1.0;
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            double p = succProb[i];
            adjList.get(a).add(new Pair(b, p));
            adjList.get(b).add(new Pair(a, p));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair(start_node, 1));
        while(!pq.isEmpty()){
            Pair top = pq.remove();
            int topNode = top.node;
            double topProb = top.prob;
            if(topNode == end_node){
                return topProb;
            }
            if(topProb < probabilities[topNode]){
                continue;
            }
            for(Pair p : adjList.get(topNode)){
                int currNode = p.node;
                double currProb = p.prob;
                if(currProb * topProb > probabilities[currNode]){
                    probabilities[currNode] = currProb * topProb;
                    pq.add(new Pair(currNode, currProb * topProb));
                }
            }
        }
        return 0;
    }
}