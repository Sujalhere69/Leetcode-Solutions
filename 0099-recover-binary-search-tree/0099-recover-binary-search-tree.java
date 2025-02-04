class Solution {
    private TreeNode first, middle, last, prev;

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        
        // Step 1: In-order traversal to identify swapped nodes
        inorder(root);

        // Step 2: Swap the incorrect nodes
        if (first != null && last != null) {
            // Case 1: Two non-adjacent nodes swapped
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            // Case 2: Two adjacent nodes swapped
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        // Inorder traversal (Left -> Root -> Right)
        inorder(root.left);

        // Identify swapped nodes
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                middle = root; // Possible adjacent swap
            } else {
                last = root; // Non-adjacent swap
            }
        }
        prev = root; // Update previous node
        
        inorder(root.right);
    }
}
