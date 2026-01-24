package january;

import java.util.Arrays;
import java.util.Scanner;

public class Jan24MinimizeMaximumPairSumInArray {
    class Solution {
        public int minPairSum(int[] nums) {
            // Get array length and initialize variable to track maximum pair sum
            int n = nums.length, maxPairSum = 0;
            // Sort array to pair smallest with largest elements
            Arrays.sort(nums);

            // Use two pointers: one at start, one at end
            int i = 0, j = n - 1;
            // Iterate until pointers meet
            while (i < j) {
                // Calculate sum of current pair and update maximum if needed
                maxPairSum = Math.max(maxPairSum, nums[i] + nums[j]);
                // Move pointers towards each other
                i++;
                j--;
            }

            // Return the minimum of all maximum pair sums
            return maxPairSum;
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

        Solution solution = new Jan24MinimizeMaximumPairSumInArray().new Solution();
        System.out.println(solution.minPairSum(nums));

        scanner.close();
    }
}
