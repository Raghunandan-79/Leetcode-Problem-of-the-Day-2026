package march;

import java.util.Scanner;

public class Mar4SpecialPositionsInABinaryMatrix {
    class Solution {
        public int numSpecial(int[][] mat) {
            // Get matrix dimensions
            int rows = mat.length;
            int cols = mat[0].length;

            // Count the number of 1s in each row and column
            int[] rowCount = new int[rows];
            int[] colCount = new int[cols];

            // Traverse the matrix and count 1s per row and column
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 1) {
                        rowCount[i]++;
                        colCount[j]++;
                    }
                }
            }

            // Count special positions (1s with exactly one 1 in row and column)
            int result = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                        result++;
                    }
                }
            }

            return result;
        }
    }

    // Driver code - this should not be submitted to leetcode
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

        Solution solution = new Mar4SpecialPositionsInABinaryMatrix().new Solution();
        System.out.println(solution.numSpecial(mat));

        scanner.close();
    }
}
