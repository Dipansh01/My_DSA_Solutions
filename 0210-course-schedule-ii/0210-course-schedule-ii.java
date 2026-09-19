class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adjList.get(b).add(a);
            inDegree[a]++;
        }
        int[] topSort = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        int i = 0;
        while(!q.isEmpty()){
            int front = q.remove();
            topSort[i] = front;
            i++;
            for(int num : adjList.get(front)){
                inDegree[num]--;
                if(inDegree[num] == 0){
                    q.add(num);
                }
            }
        }
        if(i == numCourses){
            return topSort;
        }
        return new int[0];
    }
}