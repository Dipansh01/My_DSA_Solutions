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
class Quad{
    int min;
    int max;
    int sum;
    boolean isBST;
    Quad(int min, int max, int sum, boolean isBST){
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.isBST = isBST;
    }
}
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        helper(root);
        if(maxSum < 0){
            maxSum = 0;
        }
        return maxSum;
    }
    public Quad helper(TreeNode root){
        if(root == null){
            return new Quad(Integer.MAX_VALUE,Integer.MIN_VALUE,0,true);
        }
        Quad lbst = helper(root.left);
        Quad rbst = helper(root.right);
        int min = Math.min(root.val,Math.min(lbst.min,rbst.min));
        int max = Math.max(root.val,Math.max(lbst.max,rbst.max));
        int sum = root.val + lbst.sum + rbst.sum;
        boolean isBST = lbst.isBST && rbst.isBST && (root.val>lbst.max && root.val<rbst.min);
        if(isBST){
            maxSum = Math.max(maxSum,sum);
        }
        return new Quad(min,max,sum,isBST);
    }
}