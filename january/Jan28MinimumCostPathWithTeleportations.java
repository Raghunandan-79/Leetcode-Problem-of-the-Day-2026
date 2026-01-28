package january;

import java.util.Arrays;

public class Jan28MinimumCostPathWithTeleportations {
    class Solution {
        public int minCost(int[][] grid, int k) {
            // Get grid dimensions
            int m = grid.length;
            int n = grid[0].length;
            // If teleportation is available and start cost >= end cost, we can teleport for free
            if (k > 0 && grid[0][0] >= grid[m - 1][n - 1]) {
                return 0;
            }

            // Find the maximum cost value in the grid
            int mx = 0;
            for (int[] row : grid) {
                for (int x : row) {
                    mx = Math.max(mx, x);
                }
            }

            // Arrays to track minimum costs
            int[] sufMinF = new int[mx + 2]; // Suffix minimum costs for each value
            Arrays.fill(sufMinF, Integer.MAX_VALUE);
            int[] minF = new int[mx + 1]; // Minimum cost for each grid value
            int[] f = new int[n + 1]; // DP array for current row

            // Process up to k teleportations
            for (int t = 0; t <= k; t++) {
                Arrays.fill(minF, Integer.MAX_VALUE);
                Arrays.fill(f, Integer.MAX_VALUE / 2);
                f[1] = -grid[0][0]; // Start position
                
                // Process each cell in the grid
                for (int[] row : grid) {
                    for (int j = 0; j < n; j++) {
                        int x = row[j];
                        // Calculate minimum cost: move or teleport
                        f[j + 1] = Math.min(Math.min(f[j], f[j + 1]) + x, sufMinF[x]);
                        minF[x] = Math.min(minF[x], f[j + 1]);
                    }
                }
                
                // Update suffix minimums and check if converged
                boolean done = true;
                for (int i = mx; i >= 0; i--) {
                    int mn = Math.min(sufMinF[i + 1], minF[i]);
                    if (mn < sufMinF[i]) {
                        sufMinF[i] = mn;
                        done = false;
                    }
                }
                // Exit early if no improvements
                if (done) {
                    break;
                }
            }

            return f[n];
        }
    }

    // Driver code - This should not be submitted to leetcode
    public static void main(String[] args) {
        Solution solution = new Jan28MinimumCostPathWithTeleportations().new Solution();
        int[][] grid1 = {{2, 1}, {1, 2}};
        System.out.println(solution.minCost(grid1, 0)); // Expected output
        int[][] grid2 = {{1, 3, 1}, {5, 2, 2}, {4, 3, 2}};
        System.out.println(solution.minCost(grid2, 1)); // Expected output
    }
}
