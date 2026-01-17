package january;

import java.util.Scanner;

public class Jan17FindTheLargestAreaOfSquareInsideTwoRectangles {
    class Solution {
        public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
            int n = bottomLeft.length;
            long maxSide = 0;

            // Compare each pair of rectangles
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    // Calculate the width of the intersection
                    int w = Math.min(topRight[i][0], topRight[j][0]) - Math.max(bottomLeft[i][0], bottomLeft[j][0]);

                    // Calculate the height of the intersection
                    int h = Math.min(topRight[i][1], topRight[j][1]) - Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                    
                    // The largest square side is limited by the smaller dimension
                    int side = Math.min(w, h);

                    // Track the maximum side length (only positive values form valid squares)
                    maxSide = Math.max(maxSide, side);
                }
            }

            // Return the area of the largest square
            return maxSide * maxSide;
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] bottomLeft = new int[n][m];
        int[][] topRight = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bottomLeft[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                topRight[i][j] = scanner.nextInt();
            }
        }

        Solution solution = new Jan17FindTheLargestAreaOfSquareInsideTwoRectangles().new Solution();
        System.out.println(solution.largestSquareArea(bottomLeft, topRight));

        scanner.close();
    }
}
