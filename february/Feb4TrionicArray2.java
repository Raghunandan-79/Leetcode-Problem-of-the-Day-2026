package february;

import java.util.ArrayList;
import java.util.List;

public class Feb4TrionicArray2 {
    class Solution {
        // Inner class to represent a triple (p, q, sum)
        static class Triple {
            int p, q;
            long sum;

            Triple(int p, int q, long sum) {
                this.p = p;
                this.q = q;
                this.sum = sum;
            }
        }

        // Decompose array into subarrays where each subarray is non-increasing
        public List<Triple> decompose(int[] nums) {
            int n = nums.length;
            List<Triple> subarrays = new ArrayList<>();

            int l = 0;
            long sum = nums[0];

            // Iterate through array and split when we find an increasing pair
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] <= nums[i]) {
                    subarrays.add(new Triple(l, i - 1, sum));
                    l = i;
                    sum = 0;
                }

                sum += nums[i];
            }

            subarrays.add(new Triple(l, n - 1, sum));

            return subarrays;
        }

        // Find maximum sum of a trionic subarray
        public long maxSumTrionic(int[] nums) {
            int n = nums.length;

            // maxEndingAt[i] = max sum of increasing subarray ending at i
            long[] maxEndingAt = new long[n];
            for (int i = 0; i < n; i++) {
                maxEndingAt[i] = nums[i];

                if (i > 0 && nums[i - 1] < nums[i] && maxEndingAt[i - 1] > 0) {
                    maxEndingAt[i] += maxEndingAt[i - 1];
                }
            }

            // maxStartingAt[i] = max sum of increasing subarray starting at i
            long[] maxStartingAt = new long[n];
            for (int i = n - 1; i >= 0; i--) {
                maxStartingAt[i] = nums[i];

                if (i < n - 1 && nums[i] < nums[i + 1] && maxStartingAt[i + 1] > 0) {
                    maxStartingAt[i] += maxStartingAt[i + 1];
                }
            }

            // Get all non-increasing subarrays
            List<Triple> PQS = decompose(nums);
            long ans = Long.MIN_VALUE;

            // Check each non-increasing subarray as middle part of trionic
            for (Triple t : PQS) {
                int p = t.p, q = t.q;

                // Valid trionic: increasing + non-increasing + increasing
                if (p > 0 && q < n - 1 && nums[p - 1] < nums[p] && nums[q] < nums[q + 1] && p < q) {
                    long cand = maxEndingAt[p - 1] + t.sum + maxStartingAt[q + 1];
                    ans = Math.max(ans, cand);
                }
            }

            return ans;
        }
    }

    // Driver code - This should not be submitted to leetcoe
    public static void main(String[] args) {
        Solution solution = new Feb4TrionicArray2().new Solution();

        // Test case 1
        int[] nums1 = { 1, 2, 3, 4, 5 };
        System.out.println("Test 1: " + solution.maxSumTrionic(nums1));

        // Test case 2
        int[] nums2 = { 5, 4, 3, 2, 1 };
        System.out.println("Test 2: " + solution.maxSumTrionic(nums2));

        // Test case 3
        int[] nums3 = { 1, 5, 2, 4, 3 };
        System.out.println("Test 3: " + solution.maxSumTrionic(nums3));
    }
}
