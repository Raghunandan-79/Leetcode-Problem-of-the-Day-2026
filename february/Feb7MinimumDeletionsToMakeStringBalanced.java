package february;

import java.util.Scanner;

public class Feb7MinimumDeletionsToMakeStringBalanced {
    class Solution {
        public int minimumDeletions(String s) {
            int n = s.length();
            int cnt = 0;  // Count of 'b' characters seen so far
            int ans = 0;  // Number of deletions needed

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'b') {
                    cnt++;  // Increment 'b' count
                }
                if (s.charAt(i) == 'a' && cnt > 0) {
                    cnt--;      // Remove one 'b' from our count
                    ans++;      // Increment deletion count
                }
            }

            return ans;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Solution solution = new Feb7MinimumDeletionsToMakeStringBalanced().new Solution();
        System.out.println(solution.minimumDeletions(s));

        scanner.close();
    }
}
