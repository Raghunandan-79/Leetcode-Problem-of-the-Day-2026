package march;

import java.util.ArrayList;
import java.util.List;

public class Mar14TheKthLexographicalStringOfAllHappyStringsOfLenghtN {
    class Solution {
        public String getHappyString(int n, int k) {
            // Total number of happy strings of length n
            int total = 3 * (1 << (n - 1));
            if (k > total)
                return ""; // If k is out of bounds, return empty string

            StringBuilder ans = new StringBuilder();
            char prev = '#'; // Placeholder for previous character

            for (int pos = 0; pos < n; pos++) {
                List<Character> choices = new ArrayList<>();

                // Build list of valid choices (no consecutive same chars)
                for (char ch : new char[] { 'a', 'b', 'c' }) {
                    if (ch != prev) {
                        choices.add(ch);
                    }
                }

                int remaining = n - pos - 1;
                int blockSize = 1 << remaining; // Number of happy strings for each choice at this position

                // Find the correct character for current position
                for (char ch : choices) {
                    if (k > blockSize) {
                        k -= blockSize; // Skip this block
                    } else {
                        ans.append(ch); // Choose this character
                        prev = ch;      // Update previous character
                        break;
                    }
                }
            }

            return ans.toString();
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Solution sol = new Mar14TheKthLexographicalStringOfAllHappyStringsOfLenghtN().new Solution();
        System.out.println(sol.getHappyString(3, 9));
    }
}