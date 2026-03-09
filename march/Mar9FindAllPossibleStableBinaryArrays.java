package march;

import java.util.Scanner;

public class Mar9FindAllPossibleStableBinaryArrays {
    class Solution {
        public int numberOfStableArrays(int zero, int one, int limit) {
            final long MOD = 1000000007;
            // dp[i][j][k] = number of stable arrays with i zeros, j ones, ending with digit k
            long[][][] dp = new long[zero + 1][one + 1][2];

            // Initialize: arrays with only zeros (up to limit)
            for (int i = 0; i <= Math.min(zero, limit); i++) {
                dp[i][0][0] = 1;
            }
            
            // Initialize: arrays with only ones (up to limit)
            for (int j = 0; j <= Math.min(one, limit); j++) {
                dp[0][j][1] = 1;
            }
            
            // Fill dp table
            for (int i = 1; i <= zero; i++) {
                for (int j = 1; j <= one; j++) {
                    // Calculate arrays ending with 0
                    if (i > limit) {
                        // Subtract invalid cases where we have more than 'limit' consecutive zeros
                        dp[i][j][0] =
                            dp[i - 1][j][0] +
                            dp[i - 1][j][1] -
                            dp[i - limit - 1][j][1];
                    } else {
                        dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                    }
                    
                    dp[i][j][0] = ((dp[i][j][0] % MOD) + MOD) % MOD;
                    
                    // Calculate arrays ending with 1
                    if (j > limit) {
                        // Subtract invalid cases where we have more than 'limit' consecutive ones
                        dp[i][j][1] =
                            dp[i][j - 1][1] +
                            dp[i][j - 1][0] -
                            dp[i][j - limit - 1][0];
                    } else {
                        dp[i][j][1] = dp[i][j - 1][1] + dp[i][j - 1][0];
                    }
                    
                    dp[i][j][1] = ((dp[i][j][1] % MOD) + MOD) % MOD;
                }
            }
            
            // Return sum of stable arrays ending with 0 or 1
            return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int zero = scanner.nextInt();
        int one = scanner.nextInt();
        int limit = scanner.nextInt();
        Solution solution = new Mar9FindAllPossibleStableBinaryArrays().new Solution();
        int result = solution.numberOfStableArrays(zero, one, limit);
        System.out.println(result);
        scanner.close();
    }
}
