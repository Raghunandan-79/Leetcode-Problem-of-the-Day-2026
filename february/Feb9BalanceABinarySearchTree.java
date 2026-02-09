package february;

import java.util.ArrayList;
import java.util.List;

public class Feb9BalanceABinarySearchTree {
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
        public void inorder(TreeNode node, List<Integer> vals) {
            if (node == null) return;
            inorder(node.left, vals);
            vals.add(node.val);
            inorder(node.right, vals);
        }

        public TreeNode build(List<Integer> vals, int l, int r) {
            if (l > r) return null;
            int mid = (l + r) / 2;
            TreeNode node = new TreeNode(vals.get(mid));
            node.left  = build(vals, l, mid - 1);
            node.right = build(vals, mid + 1, r);
            return node;
        }
        
        public TreeNode balanceBST(TreeNode root) {
            List<Integer> vals = new ArrayList<>();
            inorder(root, vals);
            return build(vals, 0, vals.size() - 1);
        }
    }

    public static void main(String[] args) {
        Feb9BalanceABinarySearchTree tree = new Feb9BalanceABinarySearchTree();
        Solution solution = tree.new Solution();
        
        // Example: Create an unbalanced BST
        TreeNode root = tree.new TreeNode(1);
        root.right = tree.new TreeNode(2);
        root.right.right = tree.new TreeNode(3);
        root.right.right.right = tree.new TreeNode(4);
        
        // Balance the tree
        TreeNode balanced = solution.balanceBST(root);
        
        // Print the balanced tree (in-order traversal)
        List<Integer> result = new ArrayList<>();
        solution.inorder(balanced, result);
        System.out.println("Balanced BST (in-order): " + result);
    }
}
