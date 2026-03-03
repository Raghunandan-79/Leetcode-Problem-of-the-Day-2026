package march;

import java.util.Scanner;

public class Mar3FindKthBitInNthBinaryString {
    class Solution {
        public char findKthBit(int n, int k) {
            // Initialize the string with "0"
            StringBuilder s = new StringBuilder("0");

            // Build the nth binary string iteratively
            for (int i = 2; i <= n; i++) {
                // Create inverted version of current string
                StringBuilder inverted = new StringBuilder();

                // Invert each bit (0 -> 1, 1 -> 0)
                for (int j = 0; j < s.length(); j++) {
                    inverted.append(s.charAt(j) == '0' ? '1' : '0');
                }

                // Reverse the inverted string
                inverted.reverse();
                
                // Append "1" and reversed inverted string to build next iteration
                s.append("1").append(inverted);
            }

            // Return the kth bit (convert to 0-indexed)
            return s.charAt(k - 1);
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Solution solution = new Mar3FindKthBitInNthBinaryString().new Solution();
        System.out.println(solution.findKthBit(n, k));

        scanner.close();
    }
}
