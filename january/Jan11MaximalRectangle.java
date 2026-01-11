package january;

import java.util.Scanner;

public class Jan11MaximalRectangle {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            // Handle edge cases
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

            int m = matrix.length;
            int n = matrix[0].length;

            // Create integer matrix to store cumulative widths
            int[][] mat = new int[m][n];

            // Convert char matrix ('0', '1') to int matrix
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = matrix[i][j] - '0';
                }
            }

            // Calculate row-wise prefix sums (cumulative widths for each row)
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (mat[i][j] == 1) {
                        mat[i][j] += mat[i][j - 1];
                    }
                }
            }

            int ans = 0;

            // Fix each column as the right boundary
            for (int j = 0; j < n; j++) {
                // For each row in that column
                for (int i = 0; i < m; i++) {
                    int width = mat[i][j];
                    if (width == 0) continue;

                    // Expand downward and calculate max rectangle area
                    int currWidth = width;
                    for (int k = i; k < m && mat[k][j] > 0; k++) {
                        currWidth = Math.min(currWidth, mat[k][j]);
                        int height = k - i + 1;
                        ans = Math.max(ans, currWidth * height);
                    }

                    // Expand upward and calculate max rectangle area
                    currWidth = width;
                    for (int k = i; k >= 0 && mat[k][j] > 0; k--) {
                        currWidth = Math.min(currWidth, mat[k][j]);
                        int height = i - k + 1;
                        ans = Math.max(ans, currWidth * height);
                    }
                }
            }

            // returning ans
            return ans;
        }
    }

    // Driver code - This should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        char[][] matrix = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.next().charAt(0);
            }
        }

        Solution solution = new Jan11MaximalRectangle().new Solution();
        System.out.println(solution.maximalRectangle(matrix));

        scanner.close();
    }
}
