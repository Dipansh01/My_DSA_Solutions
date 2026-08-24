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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int res = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            res += dfs(temp, targetSum);
            if(temp.left != null){
                st.push(temp.left);
            }
            if(temp.right != null){
                st.push(temp.right);
            }
        }
        return res;
    }
    public int dfs(TreeNode root, long targetSum){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.val == targetSum){
            count++;
        }
        count += dfs(root.left, targetSum-root.val);
        count += dfs(root.right, targetSum-root.val);
        return count;
    }
}