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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null){
            return arr;
        }
        helper(root,arr,0);
        return arr;  
    }
    public void helper(TreeNode root, ArrayList<Integer> arr, int level){
        if(root == null){
            return;
        }
        if(level == arr.size()){
            arr.add(root.val);
        }
        else{
            arr.set(level,root.val);
        }
        helper(root.left,arr,level+1);
        helper(root.right,arr,level+1);
    }
}