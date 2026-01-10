package january;

import java.util.Scanner;

public class Jan10MinimumAsciiDeleteSumForTwoStrings {
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            // Initialize DP table dimensions based on string lengths
            int n = s1.length(), m = s2.length();
            int[][] dp = new int[n + 1][m + 1];

            // Build DP table to find longest common subsequence (by ASCII value)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        // Characters match: add ASCII value to previous diagonal
                        dp[i + 1][j + 1] = dp[i][j] + s1.charAt(i);
                    } else {
                        // Characters don't match: take max from left or top
                        dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                    }
                }
            }

            // Calculate total ASCII sum of both strings
            int total = 0;
            for (char c : s1.toCharArray()) total += c;
            for (char c : s2.toCharArray()) total += c;

            // Return total sum minus twice the LCS sum (characters to delete)
            return total - 2 * dp[n][m];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next(), s2 = scanner.next();

        Solution solution = new Jan10MinimumAsciiDeleteSumForTwoStrings().new Solution();

        System.out.println(solution.minimumDeleteSum(s1, s2));

        scanner.close();
    }
}
