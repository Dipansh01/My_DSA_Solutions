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
            return root;
        }
        if((root.val==p.val) || (root.val==q.val)){
            return root;
        }
        boolean pInLeft = exists(root.left,p);
        boolean qInRight = exists(root.right,q);
        if((!pInLeft) && (qInRight)){
            return lowestCommonAncestor(root.right,p,q);
        }
        if((pInLeft) && !(qInRight)){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
    public boolean exists(TreeNode root, TreeNode x){
        if(root == null){
            return false;
        }
        if(root.val == x.val){
            return true;
        }
        return (exists(root.left,x) || exists(root.right,x));
    }
}