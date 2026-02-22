package february;

import java.util.Scanner;

public class Feb22BinaryGap {
    class Solution {
        public int binaryGap(int n) {
            int max_distance = 0, prev = -1, curr = n;

            // Iterate through all set bits (1s) in the binary representation
            while (curr != 0) {
                // Find the position of the rightmost set bit
                int pos = Integer.numberOfTrailingZeros(curr);

                // Calculate distance between consecutive set bits
                if (prev != -1) {
                    int distance = pos - prev;
                    max_distance = Math.max(max_distance, distance);
                }

                // Update previous position
                prev = pos;

                // Remove the rightmost set bit using bit manipulation (n & (n-1))
                curr = curr & (curr - 1);
            }

            return max_distance;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Solution solution = new Feb22BinaryGap().new Solution();
        System.out.println(solution.binaryGap(n));

        scanner.close();
    }
}
