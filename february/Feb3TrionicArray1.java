package february;

import java.util.Scanner;

public class Feb3TrionicArray1 {
    class Solution {
        public boolean isTrionic(int[] nums) {
            int n = nums.length;
            if (n < 4) return false;

            // Track the state: 0 = increasing, 1 = decreasing, 2 = increasing again
            int state = 0;
            for (int i = 0; i < n - 1; i++) {
                if (state == 0) {
                    // State 0: Strictly increasing phase
                    if (nums[i] < nums[i + 1]) {
                        // Continue increasing
                    } else if (i > 0 && nums[i] > nums[i + 1]) {
                        // Transition to decreasing phase
                        state = 1;
                    } else {
                        // Invalid: equal or decreasing at start
                        return false;
                    }
                } else if (state == 1) {
                    // State 1: Strictly decreasing phase
                    if (nums[i] > nums[i + 1]) {
                        // Continue decreasing
                    } else if (nums[i] < nums[i + 1]) {
                        // Transition to increasing phase
                        state = 2;
                    } else {
                        // Invalid: equal values
                        return false;
                    }
                } else if (state == 2) {
                    // State 2: Final strictly increasing phase
                    if (nums[i] < nums[i + 1]) {
                        // Continue increasing
                    } else {
                        // Invalid: not increasing in final phase
                        return false;
                    }
                }
            }

            // Valid only if we reached the final increasing phase
            return state == 2;
        }
    }

    // Driver code - This should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Feb3TrionicArray1().new Solution();
        System.out.println(solution.isTrionic(nums));

        scanner.close();
    }
}
