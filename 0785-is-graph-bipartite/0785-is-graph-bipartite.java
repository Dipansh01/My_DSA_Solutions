class Solution {

    private boolean isSafe(int node, int[] color, int[][] graph, int targetColor) {

        for (int neighbor : graph[node]) {
            if (color[neighbor] == targetColor) {
                return false;
            }
        }

        return true;
    }

    private boolean solve(int node, int[] color, int[][] graph) {

        for (int i = 1; i <= 2; i++) {

            if (isSafe(node, color, graph, i)) {

                color[node] = i;

                for (int neighbor : graph[node]) {

                    if (color[neighbor] == 0) {

                        if (!solve(neighbor, color, graph)) {
                            return false;
                        }
                    }
                }

                return true;
            }
        }

        return false;
    }

    public boolean isBipartite(int[][] graph) {

        int N = graph.length;
        int[] color = new int[N];

        for (int i = 0; i < N; i++) {

            if (color[i] == 0) {

                if (!solve(i, color, graph)) {
                    return false;
                }
            }
        }

        return true;
    }
}