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
    public TreeNode insert(TreeNode root, int val){
        if(root==null)
            return new TreeNode(val);
        if(root.val>val)
            root.left = insert(root.left, val);
        if(root.val<val)
            root.right = insert(root.right, val);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root= null;
        for(int n: preorder)
            root = insert(root, n);
        return root;
    }
}