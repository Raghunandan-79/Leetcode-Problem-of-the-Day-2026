package january;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NRepeatedElementsInSize2nArray {
    class Solution {
        public int repeatedNTimes(int[] nums) {
            // take half size of the array
            int n = nums.length / 2;

            // take a hashmap to store frequency
            HashMap<Integer, Integer> map = new HashMap<>();

            // put all elements in hashmap
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // iterate over the map
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                // if frequency at any point is half size of the array return the value
                if (entry.getValue() == n) {
                    return entry.getKey();
                }
            }

            // base case will not execute
            return -1;
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new NRepeatedElementsInSize2nArray().new Solution();
        System.out.println(solution.repeatedNTimes(nums));

        scanner.close();
    }
}
