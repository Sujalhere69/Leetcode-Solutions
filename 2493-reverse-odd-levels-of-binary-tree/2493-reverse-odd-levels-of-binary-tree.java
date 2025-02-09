import java.util.*;

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nodesAtLevel = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 != 0) {  // Store nodes of odd levels
                    nodesAtLevel.add(node);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Reverse values at odd levels
            int left = 0, right = nodesAtLevel.size() - 1;
            while (left < right) {
                int temp = nodesAtLevel.get(left).val;
                nodesAtLevel.get(left).val = nodesAtLevel.get(right).val;
                nodesAtLevel.get(right).val = temp;
                left++;
                right--;
            }

            level++; // Move to the next level
        }

        return root;
    }
}
