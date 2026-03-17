package march;

import java.util.Arrays;
import java.util.Scanner;

public class Mar17LargestSubmatrixWithRearrangements {
    class Solution {
        public int largestSubmatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] height = new int[m][n];

            // 1. Calculate the height of consecutive 1s for each column
            for (int j = 0; j < n; j++) {
                height[0][j] = matrix[0][j];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1)
                        height[i][j] = height[i - 1][j] + 1;
                }
            }

            int ans = 0;
            // 2. Sort heights in each row and calculate max area
            for (int i = 0; i < m; i++) {
                Arrays.sort(height[i]);
                for (int j = 0; j < n; j++) {
                    // height[i][j] is the min height for (n - j) columns
                    ans = Math.max(ans, height[i][j] * (n - j));
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        Solution solution = new Mar17LargestSubmatrixWithRearrangements().new Solution();
        int result = solution.largestSubmatrix(matrix);
        System.out.println(result);
        scanner.close();
    }
}
