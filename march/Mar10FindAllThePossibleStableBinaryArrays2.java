package march;

import java.util.Scanner;

public class Mar10FindAllThePossibleStableBinaryArrays2 {
    class Solution {
        public int numberOfStableArrays(int zero, int one, int limit) {
            int MOD = (int) 1e9 + 7;

            // dp0[o][z] = number of stable arrays ending with 0, using o ones and z zeros
            // dp1[o][z] = number of stable arrays ending with 1, using o ones and z zeros
            int[][] dp0 = new int[one + 1][zero + 1];
            int[][] dp1 = new int[one + 1][zero + 1];

            // Base case: arrays with only ones (ending with 1)
            for (int i = 1; i <= Math.min(one, limit); i++) {
                dp1[i][0] = 1;
            }

            // Base case: arrays with only zeros (ending with 0)
            for (int j = 1; j <= Math.min(zero, limit); j++) {
                dp0[0][j] = 1;
            }

            // Fill DP tables
            for (int o = 1; o <= one; o++) {
                for (int z = 1; z <= zero; z++) {
                    if (o == 0 && z == 0)
                        continue;

                    // Update dp0: arrays ending with 0
                    dp0[o][z] = dp1[o][z - 1];
                    dp0[o][z] = (dp0[o][z] + dp0[o][z - 1]) % MOD;
                    // Subtract invalid cases where we have more than limit consecutive zeros
                    if (z - limit - 1 >= 0) {
                        dp0[o][z] = (dp0[o][z] - dp1[o][z - limit - 1] + MOD) % MOD;
                    }

                    // Update dp1: arrays ending with 1
                    dp1[o][z] = dp0[o - 1][z];
                    dp1[o][z] = (dp1[o][z] + dp1[o - 1][z]) % MOD;
                    // Subtract invalid cases where we have more than limit consecutive ones
                    if (o - limit - 1 >= 0) {
                        dp1[o][z] = (dp1[o][z] - dp0[o - limit - 1][z] + MOD) % MOD;
                    }
                }
            }

            // Return total stable arrays using all ones and zeros
            return (dp0[one][zero] + dp1[one][zero]) % MOD;
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int zero = scanner.nextInt();
        int one = scanner.nextInt();
        int limit = scanner.nextInt();

        Solution solution = new Mar10FindAllThePossibleStableBinaryArrays2().new Solution();
        System.out.println(solution.numberOfStableArrays(zero, one, limit));

        scanner.close();
    }
}
