package february;

import java.util.Scanner;

public class Feb1DivideAnArrayIntoSubarraysWithMinimumCost1 {
    class Solution {
        public int minimumCost(int[] nums) {
            // Initialize variables to track the two smallest elements
            int min1 = 100;
            int min2 = 100;

            // Iterate through the array starting from index 1
            for (int i = 1; i < nums.length; i++) {
                // If current element is smaller than min1, update both
                if (nums[i] < min1) {
                    min2 = min1;
                    min1 = nums[i];
                } 
                // If current element is between min1 and min2, update min2
                else if (nums[i] < min2) {
                    min2 = nums[i];
                }
            }

            // Return sum of first element and the two smallest elements from rest
            return nums[0] + min1 + min2;
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

        Solution solution = new Feb1DivideAnArrayIntoSubarraysWithMinimumCost1().new Solution();
        System.out.println(solution.minimumCost(nums));

        scanner.close();
    }
}
