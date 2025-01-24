import java.util.HashMap;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Validate inputs
        if (inorder == null || postorder == null || postorder.length != inorder.length) {
            return null;
        }

        // Create a map to store indices of inorder elements
        HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Build the binary tree
        return buildSubtree(inorder, 0, inorder.length - 1, 
                            postorder, 0, postorder.length - 1, 
                            inorderIndexMap);
    }

    private TreeNode buildSubtree(int[] inorder, int inorderStart, int inorderEnd, 
                                  int[] postorder, int postorderStart, int postorderEnd, 
                                  HashMap<Integer, Integer> inorderIndexMap) {
        // Base case: if no elements remain, return null
        if (postorderStart > postorderEnd || inorderStart > inorderEnd) {
            return null;
        }

        // Create the root node using the last element in postorder array
        TreeNode root = new TreeNode(postorder[postorderEnd]);

        // Get the index of the root node from the inorder array
        int rootIndexInInorder = inorderIndexMap.get(postorder[postorderEnd]);

        // Calculate the number of nodes in the left subtree
        int leftSubtreeSize = rootIndexInInorder - inorderStart;

        // Recursively build the left and right subtrees
        root.left = buildSubtree(inorder, inorderStart, rootIndexInInorder - 1, 
                                 postorder, postorderStart, postorderStart + leftSubtreeSize - 1, 
                                 inorderIndexMap);
        root.right = buildSubtree(inorder, rootIndexInInorder + 1, inorderEnd, 
                                  postorder, postorderStart + leftSubtreeSize, postorderEnd - 1, 
                                  inorderIndexMap);

        return root;
    }
}
