package february;

import java.util.Scanner;

public class Feb19CountBinarySubstrings {
    class Solution {
        public int countBinarySubstrings(String s) {
            int res = 0, prev = 0, strk = 1;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) strk++;
                else {
                    prev = strk;
                    strk = 1;
                }
                if (strk <= prev) res++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Solution solution = new Feb19CountBinarySubstrings().new Solution();
        System.out.println(solution.countBinarySubstrings(s));

        scanner.close();
    }
}
