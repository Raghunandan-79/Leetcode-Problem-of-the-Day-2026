package january;

import java.util.ArrayList;
import java.util.Scanner;

public class Jan4FourDivisors {
    class Solution {
        public int sumFourDivisors(int[] nums) {
            // size of the array
            int n = nums.length;

            // variable to store total sum
            int totalSum = 0;

            // iterating the array
            for (int i = 0; i < n; i++) {
                // taking every element of array
                int num = nums[i];

                // array list to store divisors
                ArrayList<Integer> divisors = new ArrayList<>();

                // iterating till square root of number
                for (int j = 1; j * j <= num; j++) {
                    // if number modulus j is equal to 0
                    if (num % j == 0) {
                        // add j to to divisors list
                        divisors.add(j);

                        // if j is not equal to num / j
                        if (j != num / j) {
                            // adding num / j to divisors list
                            divisors.add(num / j);
                        }
                    }
                }

                // if disiors list size becomes equal to 4
                if (divisors.size() == 4) {
                    // taking sum variable to store sum
                    int sum = 0;

                    // iterating the divisors list
                    for (int k = 0; k < divisors.size(); k++) {
                        // adding every element of divisors list to the sum
                        sum += divisors.get(k);
                    }

                    // adding sum to total sum
                    totalSum += sum;
                }
            }

            // returning total sum
            return totalSum;
        }
    }

    // Driver code - This should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Jan4FourDivisors().new Solution();
        System.out.println(solution.sumFourDivisors(nums));

        scanner.close();
    }
}
