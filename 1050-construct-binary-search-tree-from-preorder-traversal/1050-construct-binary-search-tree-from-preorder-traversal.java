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
    public TreeNode bstFromPreorder(int[] preorder) {
     int[] inorder = Arrays.copyOf(preorder, preorder.length);
Arrays.sort(inorder);
 HashMap<Integer,Integer> map = new HashMap<>();
 for(int i =0 ; i<inorder.length;i++){
    map.put(inorder[i],i);
 }
 return Tree(preorder,0 ,preorder.length-1,inorder,0 , inorder.length-1,map);
    }
    public TreeNode Tree(int [] preorder, int ps , int pe , int [] inorder,int is , int ie , HashMap<Integer,Integer> map){
        if(ps> pe || is > ie){
           return null; 
        }
        int index = map.get(preorder[ps]);
        int numsLeft = index - is ;
        TreeNode root = new TreeNode(preorder[ps]);
        root.left = Tree(preorder,ps+1 , ps+numsLeft,inorder, is , index-1,map);
        root.right = Tree(preorder,ps+numsLeft+1,pe ,inorder, index +1,ie,map);
        return root;
    }
}