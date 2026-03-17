package march;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mar16GetBiggestThreeRhombusSumsInAGrid {
    class Solution {
        public int[] getBiggestThree(int[][] grid) {
            // Get grid dimensions
            int m = grid.length;
            int n = grid[0].length;

            // Set to store all unique rhombus sums
            Set<Integer> set = new HashSet<>();

            // Iterate through each cell as a potential rhombus center
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    // Add single cell as a rhombus of size 1
                    set.add(grid[i][j]);

                    // Try rhombuses of increasing sizes
                    int k = 1;
                    while (true) {

                        // Check if rhombus of size k fits within grid bounds
                        if (i - k < 0 || i + k >= m || j - k < 0 || j + k >= n)
                            break;

                        int total = 0;

                        // Top-left to center diagonal
                        int r = i - k, c = j;
                        for (int t = 0; t < k; t++)
                            total += grid[r + t][c + t];

                        // Center to bottom-right diagonal
                        r = i;
                        c = j + k;
                        for (int t = 0; t < k; t++)
                            total += grid[r + t][c - t];

                        // Bottom-right to center diagonal
                        r = i + k;
                        c = j;
                        for (int t = 0; t < k; t++)
                            total += grid[r - t][c - t];

                        // Center to top-left diagonal
                        r = i;
                        c = j - k;
                        for (int t = 0; t < k; t++)
                            total += grid[r - t][c + t];

                        // Add rhombus sum to set
                        set.add(total);
                        k++;
                    }
                }
            }

            // Convert set to sorted list in descending order
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list, Collections.reverseOrder());

            // Get up to 3 largest sums
            int size = Math.min(3, list.size());
            int[] result = new int[size];

            // Copy largest values to result array
            for (int i = 0; i < size; i++)
                result[i] = list.get(i);

            return result;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        int[][] grid = {
            {3, 4, 5, 1, 3},
            {3, 3, 4, 2, 3},
            {20, 30, 200, 40, 10},
            {1, 5, 5, 4, 1},    
            {4, 3, 2, 2, 5}
        };

        Solution solution = new Mar16GetBiggestThreeRhombusSumsInAGrid().new Solution();
        int[] result = solution.getBiggestThree(grid);
        for (int num : result) {
            System.out.print(num + " ");
        }
        
        solution = new Mar16GetBiggestThreeRhombusSumsInAGrid().new Solution();
        
        grid = new int[][] {
            {1, 2, 3},
            {4, 5, 6},   
            {7, 8, 9}
        };
        
        result = solution.getBiggestThree(grid);
        
        System.out.println();

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
