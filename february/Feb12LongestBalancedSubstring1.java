package february;

import java.util.Scanner;

public class Feb12LongestBalancedSubstring1 {
    class Solution {
        // Helper method to check if all non-zero frequencies are the same
        public static boolean issamefreq(int arr[]) {
            int value = 0;

            // Iterate through frequency array
            for (int a : arr) {
            if (a == 0)
                continue;

            // Set the expected frequency on first non-zero element
            if (value == 0)
                value = a;
            // Return false if any non-zero frequency differs
            else if (value != a)
                return false;
            }

            return true;
        }

        // Find the length of the longest balanced substring where all characters appear equally
        public int longestBalanced(String s) {
            int max = 0;
            int n = s.length();

            // Try each starting position
            for (int i = 0; i < n; i++) {
            int freq[] = new int[26]; // Frequency array for 26 lowercase letters

            // Try each ending position from current start
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                freq[ch - 'a']++;

                // If all characters have same frequency, update max length
                if (issamefreq(freq)) {
                max = Math.max(max, j - i + 1);
                }
            }
            }
            
            return max;
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Solution solution = new Feb12LongestBalancedSubstring1().new Solution();
        System.out.println(solution.longestBalanced(s));
    
        scanner.close();
    }
}