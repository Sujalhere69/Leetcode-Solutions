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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i =0 ; i<postorder.length ;i++){
        map.put(postorder[i],i);
       } 
    TreeNode root = Ans(preorder , 0 , preorder.length -1 , postorder, 0 , postorder.length-1 , map);
    return root;
    }
public TreeNode Ans(int [] preorder, int prs ,  int pre,int [] postorder , int pos , int poe,HashMap<Integer,Integer> map){
    if(prs > pre || pos > poe){
        return null;
    }
    TreeNode root = new TreeNode(preorder[prs]);
    if(prs == pre){
        return root;
    }
    int r = map.get(preorder[prs+1]);
    int size = r - pos+1;
    root.left = Ans(preorder ,prs+1 , prs+size,postorder , pos , r,map);
    root.right = Ans(preorder ,prs+size+1,pre,postorder, r+1 , poe,map);
    return root;
}
}