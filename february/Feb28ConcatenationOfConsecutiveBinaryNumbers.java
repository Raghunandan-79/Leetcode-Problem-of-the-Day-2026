package february;

import java.util.Scanner;

public class Feb28ConcatenationOfConsecutiveBinaryNumbers {
    class Solution {
        public int concatenatedBinary(int n) {
            String str = "";
            int mod = 1000000007;

            // Iterate from 1 to n
            for (int i = 1; i <= n; i++) {
                // Concatenate binary representation of current number
                str += Integer.toBinaryString(i);
                
                // Convert concatenated binary string to decimal and apply modulo
                long val = Long.parseLong(str, 2);
                val = val % mod;

                // Convert back to binary string for next iteration
                str = Long.toBinaryString(val);
            }
            
            // Convert final binary string to decimal and return as int
            return (int) Long.parseLong(str, 2);
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Solution solution = new Feb28ConcatenationOfConsecutiveBinaryNumbers().new Solution();
        System.out.println(solution.concatenatedBinary(n));

        scanner.close();
    }
}
