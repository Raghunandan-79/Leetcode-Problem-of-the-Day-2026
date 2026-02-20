package february;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Feb20SpecialBinaryString {
    class Solution {
        public String makeLargestSpecial(String s) {
            // Counter to track balance of '1's and '0's
            int cnt = 0;
            // List to store valid special binary strings
            List<String> list = new LinkedList<>();
            // Starting index of current substring
            int j = 0;
            
            // Iterate through the string to find special substrings
            for (int i = 0; i < s.length(); i++) {
                // Increment counter for '1', decrement for '0'
                if (s.charAt(i) == '1')
                    cnt++;
                else
                    cnt--;
                // When counter reaches 0, we've found a valid special string
                if (cnt == 0) {
                    // Recursively process inner substring and wrap with '1' and '0'
                    list.add('1' + makeLargestSpecial(s.substring(j + 1, i)) + '0');
                    // Move start index to next character
                    j = i + 1;
                }
            }

            // Sort in descending order to get largest special string
            Collections.sort(list, Collections.reverseOrder());
            
            // Concatenate all strings and return
            return String.join("", list);
        }
    }


    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Solution solution = new Feb20SpecialBinaryString().new Solution();
        System.out.println(solution.makeLargestSpecial(s));

        scanner.close();
    }
}
