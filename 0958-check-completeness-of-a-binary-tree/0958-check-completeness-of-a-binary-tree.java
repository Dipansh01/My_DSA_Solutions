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
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean f = false;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode rv = q.poll();
            if(rv == null){
                f = true;
            }
            else{
                if(f) {
                    return false;
                }
                q.add(rv.left);
                q.add(rv.right);
            }
        }
        return true;
    }
}
