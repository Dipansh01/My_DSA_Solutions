/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode leftAnswer = lowestCommonAncestor(root.left,p,q);
        TreeNode rightAnswer = lowestCommonAncestor(root.right,p,q);
        if(leftAnswer!=null && rightAnswer!=null){
            return root;
        }
        if(leftAnswer != null){
            return leftAnswer;
        }
        return rightAnswer;
    }
}