package january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Jan26MinimumAbsoluteDifference {
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            // Sort the array to find consecutive elements with minimum difference
            Arrays.sort(arr);
            
            // Find the minimum absolute difference
            int minDiff = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length - 1; i++) {
                minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
            }
            
            // Collect all pairs with the minimum difference
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0; i < arr.length - 1; i++){
                if (arr[i + 1] - arr[i] == minDiff) {
                    res.add(Arrays.asList(arr[i], arr[i + 1]));
                }
            }
            
            return res;
        }
    }

    // Driver code - This should not be submitted to Leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution solution = new Jan26MinimumAbsoluteDifference().new Solution();
        for (var num : solution.minimumAbsDifference(arr)) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
