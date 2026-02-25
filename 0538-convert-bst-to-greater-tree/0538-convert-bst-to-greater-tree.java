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
    static int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        helper(root);
        return root;
    }
    public static void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.right);
        int temp = root.val;
        sum += temp;
        root.val = sum;
        helper(root.left);
    }
}