package january;

import java.util.Scanner;

public class Jan31FindSmallestGreaterThanTarget {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            // Get the length of the letters array
            int n = letters.length;
            // Initialize binary search pointers
            int low = 0, high = n - 1;
            // Store the smallest letter greater than target, default to first letter
            char smallestGreater = letters[0];

            // Binary search to find the smallest letter greater than target
            while (low <= high) {
                // Calculate middle index
                int mid = low + (high - low) / 2;

                // If current letter is greater than target, update result and search left
                if (letters[mid] > target) {
                    smallestGreater = letters[mid];
                    high = mid - 1;
                } else {
                    // Otherwise, search right
                    low = mid + 1;
                }
            }
            
            return smallestGreater;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] letters = new char[n];

        for (int i = 0; i < n; i++) {
            letters[i] = scanner.next().charAt(0);
        }

        char target = scanner.next().charAt(0);

        Solution solution = new Jan31FindSmallestGreaterThanTarget().new Solution();
        System.out.println(solution.nextGreatestLetter(letters, target));

        scanner.close();
    }
}
