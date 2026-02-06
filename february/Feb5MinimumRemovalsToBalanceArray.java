package february;

import java.util.Arrays;
import java.util.Scanner;

public class Feb5MinimumRemovalsToBalanceArray {
    class Solution {
        public int minRemoval(int[] nums, int k) {
            int n = nums.length;
            // Sort the array to enable two-pointer approach
            Arrays.sort(nums);
            int ans = 0;

            // Two-pointer technique to find longest valid subarray
            for (int i = 0, j = 0; i < n; i++) {
                // Expand window while condition nums[i] * k >= nums[j+1] is satisfied
                while (j + 1 < n && (long) nums[i] * (long) k >= nums[j + 1]) {
                    j++;
                }

                // Track maximum window size (longest balanced subarray)
                ans = Math.max(ans, j - i + 1);
            }

            // Return minimum removals = total elements - maximum kept elements
            return n - ans;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        Solution solution = new Feb5MinimumRemovalsToBalanceArray().new Solution();
        System.out.println(solution.minRemoval(nums, k));

        scanner.close();
    }
}
