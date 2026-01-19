package january;

import java.util.Scanner;

public class Jan19MaximumSideLengthOfASquareWIthSumLessThanOrEqualToThreshold {
    class Solution {
        public int maxSideLength(int[][] mat, int threshold) {
            // Binary search on the side length of the square
            int numRows = mat.length;
            int numCols = mat[0].length;

            // Build 2D prefix sum matrix for O(1) range sum queries
            // prefixSum[r][c] = sum of all elements in mat[0..r-1][0..c-1]
            int[][] prefixSum = new int[numRows + 1][numCols + 1];

            for (int r = 1; r <= numRows; r++) {
                for (int c = 1; c <= numCols; c++) {
                    // Inclusion-exclusion principle: add current element, subtract overlapping regions
                    prefixSum[r][c] = prefixSum[r - 1][c] + prefixSum[r][c - 1] - prefixSum[r - 1][c - 1]
                            + mat[r - 1][c - 1];
                }
            }

            // Binary search range: side length from 0 to min(rows, cols)
            int lower = 0;
            int upper = Math.min(numRows, numCols);

            while (lower < upper) {
                int size = lower + (upper - lower + 1) / 2;
                boolean found = false;

                // Check if any square with side length 'size' has sum <= threshold
                for (int r = 1; r + size - 1 <= numRows && !found; r++) {
                    for (int c = 1; c + size - 1 <= numCols && !found; c++) {
                        // Calculate sum of square [r, c] to [r+size-1, c+size-1] using prefix sum
                        int sumSubMat = prefixSum[r + size - 1][c + size - 1] -
                                prefixSum[r - 1][c + size - 1] -
                                prefixSum[r + size - 1][c - 1] +
                                prefixSum[r - 1][c - 1];
                        
                        if (sumSubMat <= threshold) {
                            found = true;
                        }
                    }
                }

                // If valid square exists, search for larger; otherwise search smaller
                if (found) {
                    lower = size;
                } else {
                    upper = size - 1;
                }
            }

            return lower;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        int threshold = scanner.nextInt();

        Solution solution = new Jan19MaximumSideLengthOfASquareWIthSumLessThanOrEqualToThreshold().new Solution();
        System.out.println(solution.maxSideLength(mat, threshold));

        scanner.close();
    }
}
