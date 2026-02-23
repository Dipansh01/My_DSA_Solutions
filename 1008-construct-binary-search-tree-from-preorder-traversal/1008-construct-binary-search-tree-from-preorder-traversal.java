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
    public TreeNode bstFromPreorder(int[] preorder){
        int[] inorder = Arrays.copyOf(preorder,preorder.length);
        Arrays.sort(inorder);
        int n = preorder.length;
        return build(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode build(int[] preorder, int[] inorder, int preLow, int preHigh, int inLow, int inHigh){
        if(preLow > preHigh){
            return null;
        }
        int rData = preorder[preLow];
        TreeNode root = new TreeNode(rData);
        int r = -1;
        for(int i=inLow;i<=inHigh;i++){
            if(inorder[i] == rData){
                r = i;
                break;
            }
        }
        int cnt = r-inLow;
        root.left = build(preorder,inorder,preLow+1,preLow+cnt,inLow,r-1);
        root.right = build(preorder,inorder,preLow+cnt+1,preHigh,r+1,inHigh);
        return root;
    }
}