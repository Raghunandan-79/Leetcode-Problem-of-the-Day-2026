package february;

import java.util.Scanner;

public class Feb5TransformedArray {
    class Solution {
        public int[] constructTransformedArray(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];

            // Iterate through each element in the input array
            for (int i = 0; i < n; i++) {
                // Calculate the target index by adding current index and its value,
                // then use modulo to handle wraparound, with +n to handle negative results
                int ops = ((i + nums[i]) % n + n) % n;
                // Store the value at the calculated index in the result array
                result[i] = nums[ops];
            }

            return result;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Feb5TransformedArray().new Solution();
        for (int num : solution.constructTransformedArray(nums)) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
