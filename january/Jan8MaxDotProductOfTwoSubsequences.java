package january;

import java.util.Scanner;

public class Jan8MaxDotProductOfTwoSubsequences {
    class Solution {
        public int maxDotProduct(int[] nums1, int[] nums2) {
            // Get lengths of both arrays
            int n = nums1.length, m = nums2.length;
            // DP table to store maximum dot product up to each index pair
            int[][] dp = new int[n][m];

            // Fill DP table
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // Calculate product of current elements
                    int prod = nums1[i] * nums2[j];
                    dp[i][j] = prod;

                    // Option 1: Include current product with previous best diagonal
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.max(dp[i][j], prod + Math.max(0, dp[i-1][j-1]));
                    }

                    // Option 2: Skip current element from nums1
                    if (i > 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                    // Option 3: Skip current element from nums2
                    if (j > 0) dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                }
            }

            // Return maximum dot product
            return dp[n-1][m-1];
        }
    }

    // Driver code - This should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt(), n2 = scanner.nextInt();
        int[] nums1 = new int[n1], nums2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            nums1[i] = scanner.nextInt();
        }

        for (int i = 0; i < n2; i++) {
            nums2[i] = scanner.nextInt();
        }

        Solution solution = new Jan8MaxDotProductOfTwoSubsequences().new Solution();

        System.out.println(solution.maxDotProduct(nums1, nums2));

        scanner.close();
    }
}