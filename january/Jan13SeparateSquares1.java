package january;

import java.util.Scanner;

public class Jan13SeparateSquares1 {
    class Solution {
        public double separateSquares(int[][] squares) {
            // Calculate total area of all squares
            double totalArea = 0;
            double low = 1e18, high = -1e18;

            // Find total area and the range of y-coordinates
            for (int[] s : squares) {
                double y = s[1], l = s[2];
                totalArea += l * l;
                low = Math.min(low, y);
                high = Math.max(high, y + l);
            }

            // Binary search for the horizontal line that divides squares into equal area
            for (int i = 0; i < 80; i++) {
                double mid = (low + high) / 2.0;
                double areaBelow = 0;

                // Calculate area of squares below the line at position mid
                for (int[] s : squares) {
                    double y = s[1], l = s[2];
                    if (mid <= y) continue; // Square is entirely above the line
                    if (mid >= y + l) areaBelow += l * l; // Square is entirely below the line
                    else areaBelow += l * (mid - y); // Square is partially below the line
                }

                // Adjust search range based on whether we need to move the line up or down
                if (areaBelow * 2 < totalArea) low = mid;
                else high = mid;
            }

            return low;
        }
    }

    // Driver code - This should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] squares = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                squares[i][j] = scanner.nextInt();
            }
        }

        Solution solution = new Jan13SeparateSquares1().new Solution();
        System.out.println(solution.separateSquares(squares));

        scanner.close();
    }
}
