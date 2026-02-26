package february;

import java.util.Scanner;

public class Feb26NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    class Solution {
        public int numSteps(String s) {
            int steps = 0;
            int carry = 0;

            for (int i = s.length() - 1; i > 0; i--) {
                int bit = (s.charAt(i) - '0') + carry;

                if (bit == 1) {
                    steps += 2;
                    carry = 1;
                } else {
                    steps += 1;
                }
            }
            
            return steps + carry;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Solution solution = new Feb26NumberOfStepsToReduceANumberInBinaryRepresentationToOne().new Solution();
        System.out.println(solution.numSteps(s));

        scanner.close();
    }
}
