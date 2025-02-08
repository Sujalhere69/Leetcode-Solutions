class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return getAns(root, targetSum, 0);
    }

    private boolean getAns(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }

        sum += root.val;

        // If it's a leaf node, check if the sum equals targetSum
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }

        // Recursively check left and right subtrees
        return getAns(root.left, targetSum, sum) || getAns(root.right, targetSum, sum);
    }
}
