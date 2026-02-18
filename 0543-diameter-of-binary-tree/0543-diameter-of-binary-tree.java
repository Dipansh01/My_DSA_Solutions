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
    static int dia;
    public int diameterOfBinaryTree(TreeNode root) {
        dia = 0;
        level(root);
        return dia;
    }
    public static int level(TreeNode root){
        if(root == null){
            return 0;
        }
        int Llevel = level(root.left);
        int Rlevel = level(root.right);
        dia = Math.max(dia,Llevel+Rlevel);
        return 1 + Math.max(Llevel,Rlevel);
    }
}