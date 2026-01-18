package january;

import java.util.Scanner;

public class Jan18LargestMagicSquare {
    class Solution {
        // Finds the side length of the largest magic square in the grid
        public int largestMagicSquare(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int side = Math.min(m, n);

            // Try each possible side length from largest to smallest
            while (side > 0) {
                // Check all possible top-left positions for a square of current side length
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        // Verify the square fits within grid bounds
                        if(i + side <= m && j + side <= n){
                            // Return immediately when a valid magic square is found
                            if(isValid(grid, m, n, i, j, side)) return side;
                        }
                    }
                }
                
                side--;
            
            }

            return 0;
        }

        // Validates if a square starting at (i, j) with given side length is a magic square
        private boolean isValid(int[][] grid, int m, int n, int i, int j, int side) {
            int sum = 0;

            // Check all rows have equal sum
            for (int x = i; x < i + side; x++) {
                int summ = 0;
                
                for (int y = j; y < j + side; y++) {
                    summ += grid[x][y];
                }
                
                if (x == i) sum = summ;
                else if (sum != summ) return false;
            }

            // Check all columns have equal sum
            for (int x = j; x < j + side; x++) {
                int summ = 0;
                
                for (int y = i; y < i + side; y++) {
                    summ += grid[y][x];
                }
                
                if (sum != summ) return false;
            }

            // Check main diagonal sum
            int summ = 0;
            for (int k = 0; k < side; k++) {
                summ += grid[i + k][j + k];
            }
            
            if (sum != summ) return false;

            // Check anti-diagonal sum
            summ = 0;
            for (int k = 0; k < side; k++) {
                summ += grid[i + k][j + side - 1 - k];
            }
            
            if (sum != summ) return false;

            return true;
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        Solution solution = new Jan18LargestMagicSquare().new Solution();
        int result = solution.largestMagicSquare(grid);
        
        System.out.println(result);
        scanner.close();
    }
}
