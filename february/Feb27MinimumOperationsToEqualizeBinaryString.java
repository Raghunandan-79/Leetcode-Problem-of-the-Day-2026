package february;

import java.util.Scanner;

public class Feb27MinimumOperationsToEqualizeBinaryString {
    class Solution {
        public int minOperations(String s, int k) {
            // Count the number of zeroes and ones in the string
            int n = s.length(), zeroes = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0')
                    zeroes++;
            }

            int one = n - zeroes;
            
            // Calculate the minimum number of groups needed
            int m = (zeroes + k - 1) / k;

            // Try each possible number of groups starting from the minimum
            while (m <= n) {
                long total = (long) m * k;

                // Check if the total capacity minus zeroes is even (parity check)
                if ((total - zeroes) % 2 != 0) {
                    m++;
                    continue;
                }

                // Calculate max zeroes and ones allowed based on alternating pattern
                int max_zero = 0, max_one = 0;
                if (m % 2 == 1) {
                    max_zero = m;      // Odd groups: can have one more zero
                    max_one = m - 1;
                } else {
                    max_zero = m - 1;  // Even groups: can have one more one
                    max_one = m;
                }

                // Find the valid range for number of zeros
                long L = Math.max(zeroes, total - (long) one * max_one);
                long R = Math.min((long) zeroes * max_zero, total);

                // Check if a valid configuration exists in the range
                if (L <= R) {
                    if (L % 2 == zeroes % 2 || L + 1 <= R) {
                        return m;
                    }
                }

                m++;
            }

            return -1;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int k = scanner.nextInt();

        Solution solution = new Feb27MinimumOperationsToEqualizeBinaryString().new Solution();
        System.out.println(solution.minOperations(s, k));

        scanner.close();
    }
}
