package january;

import java.util.Arrays;
import java.util.Scanner;

public class Jan25MinimumDifferenceBetweenHighestAndLowestKScores {
    class Solution {
        public int minimumDifference(int[] nums, int k) {
            // Get the length of the array
            int n = nums.length;
            
            // Sort the array to group similar values together
            Arrays.sort(nums);
            
            // Initialize answer with the difference between first k elements
            int ans = nums[k - 1] - nums[0];
            
            // Slide a window of size k through the sorted array
            // to find the minimum difference between max and min in any k-sized subarray
            for (int i = 0; i + k <= n; i++) {
                ans = Math.min(ans, nums[i + k - 1] - nums[i]);
            }

            // Return the minimum difference found
            return ans;
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

        int k = scanner.nextInt();
        
        Solution solution = new Jan25MinimumDifferenceBetweenHighestAndLowestKScores().new Solution();
        System.out.println(solution.minimumDifference(nums, k));

        scanner.close();
    }
}
