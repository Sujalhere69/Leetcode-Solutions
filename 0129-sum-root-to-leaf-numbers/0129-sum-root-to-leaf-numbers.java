
class Solution {
        int wholeSum = 0;
    public int sumNumbers(TreeNode root) {
        findSum(root,0);
        return wholeSum;
    }

    private void findSum(TreeNode node, int currentSum) {
        if(node == null){
            return;
        }

        if (node != null && node.left == null && node.right == null){
            currentSum =(currentSum * 10 )+ node.val;
            wholeSum += currentSum;
            return;
        }
        
        findSum(node.left,(currentSum * 10 )+ node.val);
        findSum(node.right,(currentSum * 10 )+ node.val);
    }
}