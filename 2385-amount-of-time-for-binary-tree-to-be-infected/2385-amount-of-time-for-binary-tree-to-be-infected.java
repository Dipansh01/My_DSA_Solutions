/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair {
    TreeNode node;
    int dis;
    Pair(TreeNode node, int dis){
        this.node = node;
        this.dis = dis;
    }
}
class Solution {
    TreeNode start;
    HashMap<TreeNode, TreeNode> parent;
    public int amountOfTime(TreeNode root, int target) {
        parent = new HashMap<>();
        start = null;
        dfs(root, target);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        HashSet<TreeNode> burned = new HashSet<>();
        burned.add(start);
        int time = 0;
        while(!q.isEmpty()){
            Pair front = q.remove();
            TreeNode node = front.node;
            int dis = front.dis;
            time = Math.max(time, dis);
            if(node.left != null && !burned.contains(node.left)){
                q.add(new Pair(node.left, dis+1));
                burned.add(node.left);
            }
            if(node.right != null && !burned.contains(node.right)){
                q.add(new Pair(node.right, dis+1));
                burned.add(node.right);
            }
            if(parent.containsKey(node) && !burned.contains(parent.get(node))){
                q.add(new Pair(parent.get(node), dis+1));
                burned.add(parent.get(node));
            }
        }
        return time;
    }
    public void dfs(TreeNode root, int target){
        if(root == null){
            return;
        }
        if(root.val == target){
            start = root;
        }
        if(root.left != null){
            parent.put(root.left, root);
        }
        if(root.right != null){
            parent.put(root.right, root);
        }
        dfs(root.left, target);
        dfs(root.right, target);
    }
}