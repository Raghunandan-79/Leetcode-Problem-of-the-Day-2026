package february;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Feb23CheckIfAStringContainsAllBinaryCodesOfSizeK {
    class Solution {
        class RollingHash {
            long hash, power;
            int len;

            // Constructor to initialize rolling hash with first k characters
            RollingHash(String s, int len) {
                this.len = len;
                // Power of 2 represents the leftmost bit position
                this.power = 1L << (len - 1);

                // Compute hash for first k characters
                for (int i = 0; i < len; i++) {
                    hash = (hash << 1) | (s.charAt(i) - '0');
                }
            }

            // Compute hash for next substring by removing old char and adding new char
            long next(char old_char, char new_char) {
                // Remove leftmost bit (old_char), shift left, and add rightmost bit (new_char)
                hash = ((hash - (old_char - '0') * power) << 1) | (new_char - '0');
                return hash;
            }
        }

        public boolean hasAllCodes(String s, int k) {
            int n = s.length();
            // Early termination: if we don't have enough substrings of length k
            if (n - k + 1 < (1 << k))
                return false;

            // Set to store all unique binary codes of size k
            Set<Long> set = new HashSet<>();
            
            // Initialize rolling hash with first k characters
            RollingHash rh = new RollingHash(s, k);
            set.add(rh.hash);

            // Slide the window and compute hash for each substring of length k
            for (int i = k; i <= n - 1; i++) {
                char old_symbol = s.charAt(i - k), new_symbol = s.charAt(i);
                long new_s = rh.next(old_symbol, new_symbol);
                set.add(new_s);
            }

            // Check if we found all 2^k possible binary codes
            return set.size() == (1 << k);
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int k = scanner.nextInt();

        Solution solution = new Feb23CheckIfAStringContainsAllBinaryCodesOfSizeK().new Solution();
        System.out.println(solution.hasAllCodes(s, k));

        scanner.close();
    }
}
