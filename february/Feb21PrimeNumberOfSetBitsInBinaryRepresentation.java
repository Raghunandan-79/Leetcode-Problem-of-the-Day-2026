package february;

import java.util.Scanner;

public class Feb21PrimeNumberOfSetBitsInBinaryRepresentation {
    class Solution {
        // Helper method to check if a number is prime
        private boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }

            // Check divisibility up to sqrt(n)
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        }

        // Count numbers in range [left, right] that have a prime number of set bits
        public int countPrimeSetBits(int left, int right) {
            int count = 0;

            // Iterate through all numbers in the given range
            for (int i = left; i <= right; i++) {
                // Count the number of 1's in binary representation
                int setBits = Integer.bitCount(i);
            
                // If the count of set bits is prime, increment counter
                if (isPrime(setBits)) {
                    count++;
                }
            }
            
            return count;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();

        Solution solution = new Feb21PrimeNumberOfSetBitsInBinaryRepresentation().new Solution();
        System.out.println(solution.countPrimeSetBits(left, right));
    
        scanner.close();
    }
}
