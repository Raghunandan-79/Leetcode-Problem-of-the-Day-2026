package march;

import java.util.Scanner;

public class Mar11ComplementOfBase10Integer {
    class Solution {
        public int bitwiseComplement(int n) {
            // Special case: complement of 0 is 1
            if (n == 0) return 1;

            // Create a mask with 1s for all bits in n
            // numberOfLeadingZeros gives us leading zeros, so (32 - leading zeros) = actual bit length
            // (1 << bit_length) - 1 creates a mask with all 1s up to the highest set bit
            int mask = (1 << (32 - Integer.numberOfLeadingZeros(n))) - 1;
            
            // XOR with mask flips all bits: 1^1=0, 0^1=1
            return n ^ mask;
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution solution = new Mar11ComplementOfBase10Integer().new Solution();
        int result = solution.bitwiseComplement(n);
        System.out.println(result);
        scanner.close();
    }
}
