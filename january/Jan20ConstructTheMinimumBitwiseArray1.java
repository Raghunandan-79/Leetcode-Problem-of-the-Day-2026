package january;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jan20ConstructTheMinimumBitwiseArray1 {
    class Solution {
        public int[] minBitwiseArray(List<Integer> nums) {
            int n = nums.size();
            int[] res = new int[n];

            for (int i = 0; i < n; i++) {
                int num = nums.get(i);

                if ((num & 1) == 1) {
                    res[i] = num & ~(((num + 1) & ~num) >> 1);
                } else {
                    res[i] = -1;
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            nums.add(num);
        }

        Solution solution = new Jan20ConstructTheMinimumBitwiseArray1().new Solution();
        for (int num : solution.minBitwiseArray(nums)) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
