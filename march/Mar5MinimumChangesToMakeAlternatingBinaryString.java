package march;

import java.util.Scanner;

public class Mar5MinimumChangesToMakeAlternatingBinaryString {
    class Solution {
        // Counts flips needed if the alternating string starts with `ch` at index 0.
        public int help(String s, char ch) {
            int ans = 0;
            int n = s.length();

            for (int i = 0; i < n; i++) {
                // Even index should be `ch`, odd index should be the opposite.
                if (i % 2 == 0 && s.charAt(i) != ch)
                    ans++;
                else if (i % 2 == 1 && s.charAt(i) == ch)
                    ans++;
            }

            return ans;
        }

        public int minOperations(String s) {
            // Case 1: expected pattern is 0101...
            int opt1 = help(s, '0');
            // Case 2: expected pattern is 1010...
            int opt2 = help(s, '1');

            // Minimum flips among both valid alternating patterns.
            return Math.min(opt1, opt2);
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Solution solution = new Mar5MinimumChangesToMakeAlternatingBinaryString().new Solution();
        System.out.println(solution.minOperations(s));

        scanner.close();
    }
}
