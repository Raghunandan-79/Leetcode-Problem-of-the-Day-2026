package march;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Mar8FindUniqueBinaryString {
    class Solution {
        public String findDifferentBinaryString(String[] nums) {
            // Store all binary strings as integers in a set for O(1) lookup
            Set<Integer> st = new HashSet<>();
            int n = nums.length;

            // Convert each binary string to integer and add to set
            for (String str : nums) {
                st.add(Integer.parseInt(str, 2));
            }
            
            // Total possible binary strings of length n is 2^n
            int val = (int) Math.pow(2, n);
            
            // Iterate through all possible values from 0 to 2^n - 1
            for (int i = 0; i < val; i++) {
                // If current value is not in the set, we found our answer
                if (!st.contains(i)) {
                    // Convert integer to binary string
                    String s = Integer.toBinaryString(i);
                
                    // If length matches n, return it directly
                    if (s.length() == n)
                        return s;
                
                    // Pad with leading zeros to match length n
                    int len = s.length();
                
                    for (int j = 0; j < n - len; j++) {
                        s = "0" + s;
                    }
                
                    return s;
                }
            }
            
            // Should never reach here for valid input
            return "";
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] nums = new String[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.next();
        }

        Solution solution = new Mar8FindUniqueBinaryString().new Solution();
        System.out.println(solution.findDifferentBinaryString(nums));
        
        scanner.close();
    }
}
