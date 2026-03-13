package march;

public class Mar13MinimumNumberOfSecondsToMakeMountainHeightZero {
    class Solution {
        private boolean can_achieve(long time, int mountainHeight, int[] workerTimes) {
            // Total height that can be reduced by all workers in 'time' seconds
            long total_height = 0;

            for (int wt : workerTimes) {
                // Solve for maximum x such that wt * (1 + 2 + ... + x) <= time
                // The sum (1 + 2 + ... + x) = x * (x + 1) / 2
                // So, wt * x * (x + 1) / 2 <= time
                // Rearranged: x^2 + x - (2 * time / wt) <= 0
                // Use quadratic formula: x = (-1 + sqrt(1 + 8 * time / wt)) / 2
                double D = 1 + 8.0 * time / wt;
                long x = (long) ((-1 + Math.sqrt(D)) / 2);

                // Add the height this worker can reduce
                total_height += x;

                // Early exit if we've already reduced enough height
                if (total_height >= mountainHeight)
                    return true;
            }

            // Check if total reduced height is enough
            return total_height >= mountainHeight;
        }

        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
            // Initialize binary search boundaries
            long left = 1;

            // Find the minimum worker time
            int min_time = Integer.MAX_VALUE;
            for (int wt : workerTimes) {
                min_time = Math.min(min_time, wt);
            }

            // Set the upper bound for binary search
            long right = (long) min_time * (long) mountainHeight * (mountainHeight + 1) / 2;
            long answer = right;

            // Binary search for the minimum number of seconds
            while (left <= right) {
                long mid = left + (right - left) / 2;

                // Check if it's possible to achieve mountainHeight in 'mid' seconds
                if (can_achieve(mid, mountainHeight, workerTimes)) {
                    answer = mid;      // Update answer if possible
                    right = mid - 1;   // Try to find a smaller value
                } else {
                    left = mid + 1;    // Increase time if not possible
                }
            }

            return answer;
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Solution sol = new Mar13MinimumNumberOfSecondsToMakeMountainHeightZero().new Solution();
        int mountainHeight = 10;
        int[] workerTimes = {1, 2, 3};
        long result = sol.minNumberOfSeconds(mountainHeight, workerTimes);
        System.out.println(result); // Output the result
    }
}
