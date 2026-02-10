package february;

import java.util.HashMap;
import java.util.Scanner;

public class Feb10LongestBalancedSubarray1 {
    class Solution {
        public int longestBalanced(int[] nums) {
            int n = nums.length;

            int[] balance = new int[n]; // first-occurrence markers for current l
            HashMap<Integer, Integer> first = new HashMap<>(); // val -> first occurrence idx

            int result = 0;
            for (int l = n - 1; l >= 0; l--) {
                int x = nums[l];

                // If x already had a first occurrence to the right, remove that old marker.
                Integer oldpos = first.get(x);
                if (oldpos != null)
                    balance[oldpos] = 0;

                // Now x becomes first occurrence at l.
                first.put(x, l);
                balance[l] = ((x & 1) == 0) ? 1 : -1;

                // Find rightmost r >= l such that sum(balance[l..r]) == 0
                int s = 0;
                for (int r = l; r < n; r++) {
                    s += balance[r];
                    if (s == 0)
                        result = Math.max(result, r - l + 1);
                }
            }

            return result;
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

        Solution solution = new Feb10LongestBalancedSubarray1().new Solution();
        System.out.println(solution.longestBalanced(nums));

        scanner.close();
    }
}
