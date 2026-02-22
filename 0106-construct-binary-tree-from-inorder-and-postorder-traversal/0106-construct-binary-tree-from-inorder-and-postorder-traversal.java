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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n1 = inorder.length;
        int n2 = postorder.length;
        return build(inorder,postorder,0,n1-1,n2-1,0);
    }
    public TreeNode build(int[] inorder, int[] postorder, int inLow, int inHigh, int postHigh, int postLow){
        if(inLow > inHigh){
            return null;
        }
        int rData = postorder[postHigh];
        TreeNode root = new TreeNode(rData);
        int r = -1;
        for(int i=inLow;i<=inHigh;i++){
            if(inorder[i] == rData){
                r = i;
                break;
            }
        }
        int cnt = inHigh - r;
        root.right = build(inorder,postorder,r+1,inHigh,postHigh-1,postHigh-cnt);
        root.left = build(inorder,postorder,inLow,r-1,postHigh-cnt-1,postLow);
        return root;
    }
}