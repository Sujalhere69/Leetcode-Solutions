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
        if (root == null) {
            return; // Base case: if the tree is empty, do nothing.
        }
        
        // Use a stack to traverse the tree in preorder
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        TreeNode prev = null; // To track the previously processed node
        
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            
            // If there was a previous node, adjust its pointers
            if (prev != null) {
                prev.left = null;  // Set the left pointer to null (flattening)
                prev.right = current; // Connect the previous node to the current node
            }
            
            // Push right child first so left child is processed first (preorder)
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            
            // Update the previous node
            prev = current;
        }
    }
}
