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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
          StringBuilder st = new StringBuilder();
        get(root , list,st);
       
        return list;
    }
    public void get(TreeNode root , List<String> list,StringBuilder st){
       
        if(root== null){
            return;
        }
        int len = st.length();
        st.append(root.val);
      
        if(root.left == null && root.right == null){
list.add(st.toString());
        }else{
            st.append("->");
           get(root.left , list,st);
        get(root.right , list, st);
        }
       
        st.setLength(len);
    }
}