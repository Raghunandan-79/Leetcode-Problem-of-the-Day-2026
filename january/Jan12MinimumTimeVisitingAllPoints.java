package january;

import java.util.Scanner;

public class Jan12MinimumTimeVisitingAllPoints {
    class Solution {
        public int minTimeToVisitAllPoints(int[][] points) {
            int ans = 0;
            
            // Iterate through each point starting from the second point
            for (int i = 1; i < points.length; i++) {
                // Get coordinates of current point
                int x2 = points[i][0];
                int y2 = points[i][1];

                // Get coordinates of previous point
                int x1 = points[i-1][0];
                int y1 = points[i-1][1];

                // Calculate Chebyshev distance (max of absolute differences)
                // This represents the minimum time to move from one point to another
                ans += Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
            }
            
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] points = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                points[i][j] = scanner.nextInt();
            }
        }

        Solution solution = new Jan12MinimumTimeVisitingAllPoints().new Solution();

        System.out.println(solution.minTimeToVisitAllPoints(points));

        scanner.close();
    }
}
