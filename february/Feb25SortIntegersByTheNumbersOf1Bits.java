package february;

import java.util.Arrays;
import java.util.Scanner;

public class Feb25SortIntegersByTheNumbersOf1Bits {
    class Solution {
        public int[] sortByBits(int[] arr) {
            // Magic number larger than max array value (10^4) to encode bit count
            final int MAGIC_NUMBER = 10001;

            // Encode each number: add (bit count * magic number) to preserve bit count info
            for (int i = 0; i < arr.length; i++) {
                arr[i] += Integer.bitCount(arr[i]) * MAGIC_NUMBER;
            }

            // Sort by encoded values (primarily by bit count due to magnitude of magic number)
            Arrays.sort(arr);

            // Decode: extract original values by taking modulo with magic number
            for (int i = 0; i < arr.length; i++) {
                arr[i] %= MAGIC_NUMBER;
            }

            return arr;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution solution = new Feb25SortIntegersByTheNumbersOf1Bits().new Solution();
        for (var num : solution.sortByBits(arr)) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
