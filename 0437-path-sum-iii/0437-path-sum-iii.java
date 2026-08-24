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
    static int res;
    public int pathSum(TreeNode root, int targetSum) {
        res = 0;
        if(root == null){
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            dfs(temp, targetSum);
            if(temp.left != null){
                st.push(temp.left);
            }
            if(temp.right != null){
                st.push(temp.right);
            }
        }
        return res;
    }
    public static void dfs(TreeNode root, long targetSum){
        if(root == null){
            return;
        }
        if(root.val == targetSum){
            res++;
        }
        dfs(root.left, targetSum-root.val);
        dfs(root.right, targetSum-root.val);
    }
}