package march;

import java.util.Scanner;

public class Mar1PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    class Solution {
        public int minPartitions(String n) {
            // Iterate from digit '9' down to '0' to find the maximum digit
            for (char ch = '9'; ch >= '0'; ch--) {
                // If the current digit exists in the string, return it
                if (n.indexOf(ch) != -1) {
                    return ch - '0';
                }
            }

            // Return -1 if no digit is found (should not happen for valid input)
            return -1;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();

        Solution solution = new Mar1PartitioningIntoMinimumNumberOfDeciBinaryNumbers().new Solution();
        System.out.println(solution.minPartitions(n));

        scanner.close();
    }
}
