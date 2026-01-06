package january;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jan6MaximumLevelSumOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        
        TreeNode(int val) { 
            this.val = val; 
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int maxLevelSum(TreeNode root) {
            // Initialize a queue for level-order traversal
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            // Track the maximum sum and the level number with maximum sum
            int max = Integer.MIN_VALUE;
            int ans = 1;
            int curr = 1; // Current level number

            // Process each level of the binary tree
            while (!q.isEmpty()) {
                int c = 0; // Sum of current level
                int size = q.size(); // Number of nodes at current level

                // Calculate sum for all nodes at current level
                for (int i = 0; i < size; i++) {
                    TreeNode temp = q.remove();
                    c += temp.val;

                    // Add child nodes to queue for next level
                    if (temp.left != null) q.add(temp.left);
                    if (temp.right != null) q.add(temp.right);
                }

                // Update maximum sum and corresponding level
                if (c > max) {
                    max = c;
                    ans = curr;
                }

                curr += 1; // Move to next level
            }

            return ans; // Return the level with maximum sum
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jan6MaximumLevelSumOfBinaryTree obj = new Jan6MaximumLevelSumOfBinaryTree();
        Solution solution = obj.new Solution();

        // Create a sample binary tree
        TreeNode root = obj.new TreeNode(1);
        root.left = obj.new TreeNode(2);
        root.right = obj.new TreeNode(3);
        root.left.left = obj.new TreeNode(4);
        root.left.right = obj.new TreeNode(5);
        root.right.left = obj.new TreeNode(6);
        root.right.right = obj.new TreeNode(7);

        int result = solution.maxLevelSum(root);
        System.out.println(result);

        scanner.close();
    }
}
