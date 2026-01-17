package january;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Jan16MaximumSquareAreaByRemovingFencesFromAField {
    class Solution {
        public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
            // Add boundaries to fence arrays (1 and m for horizontal, 1 and n for vertical)
            int[] h = Arrays.copyOf(hFences, hFences.length + 2);
            h[hFences.length] = 1;
            h[hFences.length + 1] = m;

            int[] v = Arrays.copyOf(vFences, vFences.length + 2);
            v[vFences.length] = 1;
            v[vFences.length + 1] = n;

            // Sort fence positions
            Arrays.sort(h);
            Arrays.sort(v);

            // Calculate all possible gaps between horizontal fences
            Set<Integer> hGaps = new HashSet<>();
            for (int i = 0; i < h.length; i++) {
                for (int j = i + 1; j < h.length; j++) {
                    hGaps.add(h[j] - h[i]);
                }
            }

            // Find the maximum side length that exists in both horizontal and vertical gaps
            long maxSide = -1;
            for (int i = 0; i < v.length; i++) {
                for (int j = i + 1; j < v.length; j++) {
                    int currentGap = v[j] - v[i];
                    if (hGaps.contains(currentGap)) {
                        maxSide = Math.max(maxSide, currentGap);
                    }
                }
            }

            // Return -1 if no valid square found
            if (maxSide == -1) return -1;

            // Calculate area modulo 10^9 + 7
            long MOD = 1_000_000_007;
            return (int) ((maxSide * maxSide) % MOD);
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Jan16MaximumSquareAreaByRemovingFencesFromAField obj = new Jan16MaximumSquareAreaByRemovingFencesFromAField();
        Solution solution = obj.new Solution();
        
        // Test case: m = 4, n = 3, hFences = [2,3], vFences = [2]
        int m = 4, n = 3;
        int[] hFences = {2, 3};
        int[] vFences = {2};
        
        int result = solution.maximizeSquareArea(m, n, hFences, vFences);
        System.out.println(result);
    }
}
