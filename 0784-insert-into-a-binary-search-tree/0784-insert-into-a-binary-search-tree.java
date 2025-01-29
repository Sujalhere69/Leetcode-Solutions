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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode current = root;
         if(root==null){
            return newNode;
        }
        TreeNode parent =null;
       
        while(current!= null){
            parent = current;
           if(val<current.val){
current=current.left;
           }  else{
            current=current.right;
           }
        }
        if(val<parent.val){
            parent.left = newNode;
        }else{
            parent.right=newNode;
        }
        return root;
    }
}