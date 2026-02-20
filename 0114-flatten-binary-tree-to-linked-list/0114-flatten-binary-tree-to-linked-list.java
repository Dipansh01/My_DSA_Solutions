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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode leftSubTree = root.left;
        TreeNode rightSubTree = root.right;
        flatten(leftSubTree);
        flatten(rightSubTree);
        if(leftSubTree != null){
            root.right = leftSubTree;
        }
        root.left = null;
        TreeNode temp = leftSubTree;
        if(leftSubTree != null){
            while(temp.right != null){
                temp = temp.right;
            }
            temp.right = rightSubTree;
        }
    }
}