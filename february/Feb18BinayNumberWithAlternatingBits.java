package february;

import java.util.Scanner;

public class Feb18BinayNumberWithAlternatingBits {
    class Solution {
        public boolean hasAlternatingBits(int n) {
            // XOR n with n right-shifted by 1
            // This creates a number with all 1s if bits alternate
            int x = n ^ (n >> 1);
            
            // Check if x is all 1s by verifying (x & (x + 1)) == 0
            // If x is all 1s, x + 1 will be a power of 2, making their AND equal to 0
            return (x & (x + 1)) == 0;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        Solution solution = new Feb18BinayNumberWithAlternatingBits().new Solution();
        System.out.println(solution.hasAlternatingBits(n));

        scanner.close();
    }
}
