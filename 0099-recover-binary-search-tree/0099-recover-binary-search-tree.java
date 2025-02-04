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
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(list,root);
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        inorderSort(root,sorted);
    }
    public void inorder(List<Integer> list ,TreeNode root){
        if(root==null){
            return;
        }
        inorder(list , root.left);
        list.add(root.val);
        inorder(list,root.right);
    }
       private int index = 0;

    private void inorderSort(TreeNode root, List<Integer> sorted) {
        if (root == null) {
            return;
        }
        inorderSort(root.left, sorted);
        root.val = sorted.get(index++);  // Update tree node value
        inorderSort(root.right, sorted);
    }
}