package february;

public class Feb8BalancedBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        /**
         * Helper method to calculate the height of a tree and check if it's balanced.
         * Returns -1 if the subtree is unbalanced, otherwise returns the height.
         */
        private int height(TreeNode root) {
            // Base case: empty tree has height 0
            if (root == null) return 0;

            // Recursively get left subtree height
            int leftHeight = height(root.left);
            // If left subtree is unbalanced, propagate -1 up
            if (leftHeight == -1) return -1;

            // Recursively get right subtree height
            int rightHeight = height(root.right);
            // If right subtree is unbalanced, propagate -1 up
            if (rightHeight == -1) return -1;

            // Check if current node violates balance condition
            if (Math.abs(leftHeight - rightHeight) > 1) return -1;

            // Return height of current subtree
            return 1 + Math.max(leftHeight, rightHeight);
        }

        /**
         * Determines if a binary tree is balanced.
         * A balanced tree has height difference <= 1 at every node.
         */
        public boolean isBalanced(TreeNode root) {
            // Tree is balanced if height() doesn't return -1
            return height(root) != -1;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Feb8BalancedBinaryTree solution = new Feb8BalancedBinaryTree();
        Solution sol = solution.new Solution();

        // Test case 1: balanced tree
        TreeNode root1 = solution.new TreeNode(3);
        root1.left = solution.new TreeNode(9);
        root1.right = solution.new TreeNode(20);
        root1.right.left = solution.new TreeNode(15);
        root1.right.right = solution.new TreeNode(7);
        System.out.println("Test 1 (balanced): " + sol.isBalanced(root1)); // true

        // Test case 2: unbalanced tree
        TreeNode root2 = solution.new TreeNode(1);
        root2.left = solution.new TreeNode(2);
        root2.left.left = solution.new TreeNode(3);
        root2.left.left.left = solution.new TreeNode(4);
        System.out.println("Test 2 (unbalanced): " + sol.isBalanced(root2)); // false

        // Test case 3: empty tree
        System.out.println("Test 3 (empty): " + sol.isBalanced(null)); // true
    }
}
