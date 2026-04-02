#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int f(int i, int j, int cnt, vector<vector<int>>& coins,
          vector<vector<vector<int>>>& dp) {

        // Base case: reached the starting cell
        if (i == 0 && j == 0) {
            // If the starting cell is negative and we still have neutralizations left,
            // we can neutralize it and take 0 instead.
            if (coins[i][j] < 0 && cnt < 2) {
            return 0;
            } else {
            return coins[i][j];
            }
        }

        // Out of bounds: invalid path
        if (i < 0 || j < 0)
            return INT_MIN;

        // Return already computed result
        if (dp[i][j][cnt] != INT_MIN)
            return dp[i][j][cnt];

        // Option 1: take current cell value and move from top/left
        int take = coins[i][j] + max(f(i - 1, j, cnt, coins, dp),
                         f(i, j - 1, cnt, coins, dp));

        // Option 2: neutralize current negative cell if allowed
        int nottake = INT_MIN;
        if (coins[i][j] < 0 && cnt < 2)
            nottake = max(f(i - 1, j, cnt + 1, coins, dp),
                  f(i, j - 1, cnt + 1, coins, dp));

        // Store and return the best result
        return dp[i][j][cnt] = max(take, nottake);
    }
    
    int maximumAmount(vector<vector<int>>& coins) {
        int n = coins.size();  // Get number of rows
        int m = coins[0].size();  // Get number of columns
        // Initialize 3D DP table: dp[row][col][neutralizations_used]
        vector<vector<vector<int>>> dp(
            n, vector<vector<int>>(m, vector<int>(3, INT_MIN)));
        // Start DFS from bottom-right corner with 0 neutralizations used
        return f(n - 1, m - 1, 0, coins, dp);
    }
};

// Driver code - this should not be submitted to LeetCode
int main() {
    Solution sol;
    vector<vector<int>> coins = {
        {1, -2, 3},
        {4, 5, -6},
        {7, -8, 9}
    };
    cout << sol.maximumAmount(coins) << endl; // Output the maximum amount of money
    return 0;
}