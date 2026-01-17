package january;

import java.util.Arrays;
import java.util.Scanner;

public class Jan15MaximizeAreaOfSquareHoleInGrid {
    class Solution {
        public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
            // Sort both horizontal and vertical bars
            Arrays.sort(hBars);
            Arrays.sort(vBars);

            // Find the longest consecutive sequence in horizontal bars
            int maxH = 1, maxV = 1, curr = 1;

            for (int i = 1; i < hBars.length; i++) {
                // If current bar is consecutive to previous, increment counter
                if (hBars[i] == hBars[i - 1] + 1) curr++;
                else curr = 1;
                maxH = Math.max(maxH, curr);
            }

            // Find the longest consecutive sequence in vertical bars
            curr = 1;

            for (int i = 1; i < vBars.length; i++) {
                // If current bar is consecutive to previous, increment counter
                if (vBars[i] == vBars[i - 1] + 1) curr++;
                else curr = 1;
                maxV = Math.max(maxV, curr);
            }

            // The maximum square side is limited by the smaller dimension
            int side = Math.min(maxH + 1, maxV + 1);

            // Return the area of the square
            return side * side;
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] hBars = new int[n], vBars = new int[m];

        for (int i = 0; i < n; i++) {
            hBars[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            vBars[i] = scanner.nextInt();
        }

        Solution solution = new Jan15MaximizeAreaOfSquareHoleInGrid().new Solution();
        System.out.println(solution.maximizeSquareHoleArea(n, m, hBars, vBars));

        scanner.close();
    }
}