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
    public TreeNode deleteNode(TreeNode root, int key) {
     
        if(root==null){
            return null;
        }
        if(root.val==key){
           return helper(root);
        }
           TreeNode dummy = root;
        while(root!= null){
            if(key<root.val){
                if(root.left!= null && root.left.val==key){
            root.left = helper(root.left);
                }else{
                    root=root.left;
                }
            }else{
                if(root.right!= null && root.right.val == key){
                    root.right = helper(root.right);
                }else{
                    root=root.right;
                }
            }
        }
        return dummy;
    }
    public TreeNode helper(TreeNode root){
        if(root.left== null){
            return root.right;
        }else if(root.right == null){
            return root.left;
        }else{
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }
     private TreeNode findLastRight(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}