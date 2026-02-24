package february;

public class Feb24SumOfRootToLeafBinaryNumbers {
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
        // Main method to calculate sum of all root-to-leaf binary numbers
        public int sumRootToLeaf(TreeNode root) {
            return dfs(root, 0);
        }

        // DFS helper method to traverse the tree and accumulate binary values
        // curr: current binary number formed from root to current node
        private static int dfs(TreeNode node, int curr) {
            // Base case: if node is null, return 0
            if (node == null) return 0;

            // Update current binary number by shifting left and adding node value
            curr = curr * 2 + node.val;

            // If leaf node reached, return the complete binary number
            if (node.left == null && node.right == null) {
                return curr;
            }

            // Recursively sum values from left and right subtrees
            return dfs(node.left, curr) + dfs(node.right, curr);
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Feb24SumOfRootToLeafBinaryNumbers outer = new Feb24SumOfRootToLeafBinaryNumbers();
        Solution solution = outer.new Solution();

        // Create sample binary tree: [1,0,1,0,1,0,1]
        TreeNode root = outer.new TreeNode(1);
        root.left = outer.new TreeNode(0);
        root.right = outer.new TreeNode(1);
        root.left.left = outer.new TreeNode(0);
        root.left.right = outer.new TreeNode(1);
        root.right.left = outer.new TreeNode(0);
        root.right.right = outer.new TreeNode(1);

        int result = solution.sumRootToLeaf(root);
        System.out.println("Sum of root to leaf binary numbers: " + result);
    }
}
