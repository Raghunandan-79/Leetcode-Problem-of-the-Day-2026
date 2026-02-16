package february;

import java.util.Scanner;

public class Feb16ReverseBits {
    class Solution {
        public int reverseBits(int n) {
            int res = 0;
            
            // Process all 32 bits of the integer
            for (int i = 0; i < 32; i++) {
                // Shift result left by 1 to make space for the next bit
                res <<= 1;
                // Extract the least significant bit of n and add it to result
                res |= (n & 1);
                // Right shift n to process the next bit
                n >>>= 1;
            }

            return res;
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Solution solution = new Feb16ReverseBits().new Solution();
        System.out.println(solution.reverseBits(n));

        scanner.close();
    }
}
