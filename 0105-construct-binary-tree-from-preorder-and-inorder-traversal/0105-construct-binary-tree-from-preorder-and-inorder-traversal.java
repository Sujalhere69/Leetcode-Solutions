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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0 ; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return binary(preorder,0 , preorder.length-1,inorder,0,inorder.length-1,map);
      
    }
    public TreeNode binary(int [] preorder,int ps,int pe, int [] inorder,int is , int ie ,HashMap<Integer,Integer> map){
        if(ps>pe || is>ie){
     return null;
        }
        int index= map.get(preorder[ps]);
        int numsLeft = index- is;
        TreeNode root = new TreeNode(preorder[ps]);
        root.left = binary(preorder,ps+1,ps+numsLeft,inorder,is,index-1,map);
        root.right = binary(preorder,ps+numsLeft+1,pe,inorder,index+1,ie,map);
        return root;
    }
}