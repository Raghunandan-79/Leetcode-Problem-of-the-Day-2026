package march;

import java.util.Scanner;

public class Mar2MinimumSwapsToArrangeABinaryGrid {
    class Solution {
        public int minSwaps(int[][] grid) {
            int n = grid.length;
            int[] trailing = new int[n];

            // Count trailing zeros
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if (grid[i][j] == 0)
                        count++;
                    else
                        break;
                }
                trailing[i] = count;
            }

            int swaps = 0;

            for (int i = 0; i < n; i++) {
                int required = n - 1 - i;
                int j = i;

                // Find suitable row
                while (j < n && trailing[j] < required) {
                    j++;
                }

                if (j == n)
                    return -1; // no valid row meets requirement

                // Bubble row upward using adjacent swaps
                while (j > i) {
                    int temp = trailing[j];
                    trailing[j] = trailing[j - 1];
                    trailing[j - 1] = temp;
                    swaps++;
                    j--;
                }
            }

            return swaps;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        Solution solution = new Mar2MinimumSwapsToArrangeABinaryGrid().new Solution();
        System.out.println(solution.minSwaps(grid));

        scanner.close();
    }
}
