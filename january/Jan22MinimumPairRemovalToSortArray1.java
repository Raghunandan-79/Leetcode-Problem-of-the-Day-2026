package january;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jan22MinimumPairRemovalToSortArray1 {
    class Solution {
        boolean isNonDecreasing(List<Integer> arr) {
            // Iterate through the array starting from index 1
            for (int i = 1; i < arr.size(); i++) {
                // Check if current element is less than previous element
                if (arr.get(i) < arr.get(i - 1)) {
                    // Array is not non-decreasing
                    return false;
                }
            }
            
            // All elements are in non-decreasing order
            return true;
        }

        public int minimumPairRemoval(int[] nums) {
            // Convert array to list for easier manipulation
            List<Integer> arr = new ArrayList<>();
            
            for (int num : nums) {
                arr.add(num);
            }

            // Counter for number of pair removals
            int cnt = 0;

            // Keep removing pairs until array is non-decreasing
            while (!isNonDecreasing(arr)) {
                // Find the pair with minimum sum
                int mini = Integer.MAX_VALUE;
                int idx = 0;

                for (int i = 0; i < arr.size() - 1; i++) {
                    if (mini > arr.get(i) + arr.get(i + 1)) {
                        mini = arr.get(i) + arr.get(i + 1);
                        idx = i;
                    }
                }

                // Remove first element of pair and replace with sum
                arr.remove(idx);
                arr.set(idx, mini);
                cnt++;
            }

            return cnt;
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

        Solution solution = new Jan22MinimumPairRemovalToSortArray1().new Solution();
        System.out.println(solution.minimumPairRemoval(nums));

        scanner.close();
    }
}
