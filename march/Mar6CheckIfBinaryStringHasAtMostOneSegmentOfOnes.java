package march;

import java.util.Scanner;

public class Mar6CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    class Solution {
        public boolean checkOnesSegment(String s) {
            // Track the index of the last '1' found
            int idx = 0;

            // Iterate through the string
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    // If there's a gap between consecutive '1's, return false
                    if (i - idx > 1) {
                        return false;
                    }
                    
                    // Update the index to current position
                    idx = i;
                }
            }

            // If no gaps found, the string has at most one segment of ones
            return true;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Solution solution = new Mar6CheckIfBinaryStringHasAtMostOneSegmentOfOnes().new Solution();
        System.out.println(solution.checkOnesSegment(s));

        scanner.close();
    }
}
