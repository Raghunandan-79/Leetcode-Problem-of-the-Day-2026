package january;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jan21ConstructTheMinimumBitwiseArray2 {
    class Solution {
        public int[] minBitwiseArray(List<Integer> nums) {
            int n = nums.size();
            int[] arr = new int[n];

            // Iterate through each number in the input list
            for (int i = 0; i < n; i++) {
                int a = nums.get(i);
                int b = a + 1;

                // Special case: if a is 2, no valid bitwise result exists
                if (a == 2) {
                    arr[i] = -1;
                } else {
                    // Calculate the minimum bitwise value by subtracting the lowest set bit of (a+1)
                    arr[i] = a - ((b) & (-b)) / 2;
                }
            }

            return arr;
        }
    }

    // Driver code - This should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            nums.add(num);
        }

        Solution solution = new Jan21ConstructTheMinimumBitwiseArray2().new Solution();
        for (int num : solution.minBitwiseArray(nums)) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
