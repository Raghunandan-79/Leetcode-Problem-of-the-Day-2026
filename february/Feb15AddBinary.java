package february;

import java.util.Scanner;

public class Feb15AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            // Initialize result builder and pointers to the end of both strings
            StringBuilder result = new StringBuilder();
            int i = a.length() - 1, j = b.length() - 1, carry = 0;

            // Process both strings from right to left
            while (i >= 0 || j >= 0 || carry == 1) {
                // Start with the carry from previous iteration
                int sum = carry;
                
                // Add digit from string a if available
                if (i >= 0) sum += a.charAt(i--) - '0';
                
                // Add digit from string b if available
                if (j >= 0) sum += b.charAt(j--) - '0';

                // Append the binary digit (sum % 2) to result
                result.append(sum % 2);
                
                // Update carry for next iteration
                carry = sum / 2;
            }

            // Reverse and return the result since we built it backwards
            return result.reverse().toString();
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        Solution solution = new Feb15AddBinary().new Solution();
        System.out.println(solution.addBinary(a, b));

        scanner.close();
    }
}
