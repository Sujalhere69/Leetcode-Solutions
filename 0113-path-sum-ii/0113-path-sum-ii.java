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
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        get(root,0,target , ans,list);
        return ans;
    }
    public void get(TreeNode root ,int sum, int target , List<List<Integer>> ans,List<Integer> list){
        if(root == null){
            return ;
        }
            sum += root.val;
            list.add(root.val);
        
        if(root.left == null && root.right == null && sum == target){
            ans.add(new ArrayList<>(list));
        }else{
         get(root.left , sum , target ,ans , list);
         get(root.right , sum , target , ans , list);
        }
       list.remove(list.size()-1);
          
    }
}