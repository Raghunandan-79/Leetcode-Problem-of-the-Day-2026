#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxProductPath(vector<vector<int>>& grid) {
        int rows = grid.size(), cols = grid[0].size();
        const long long MOD = 1e9 + 7;

        // maxProd[j] = maximum product till current row at column j
        // minProd[j] = minimum product till current row at column j
        vector<long long> maxProd(cols), minProd(cols);

        maxProd[0] = minProd[0] = grid[0][0];

        // first row (only from left)
        for (int col = 1; col < cols; col++) {
            maxProd[col] = minProd[col] = maxProd[col - 1] * grid[0][col];
        }

        // process remaining rows
        for (int row = 1; row < rows; row++) {

            // first column (only from top)
            maxProd[0] = minProd[0] = maxProd[0] * grid[row][0];

            for (int col = 1; col < cols; col++) {
                long long val = grid[row][col];

                // from top
                long long topMax = maxProd[col] * val;
                long long topMin = minProd[col] * val;

                // from left
                long long leftMax = maxProd[col - 1] * val;
                long long leftMin = minProd[col - 1] * val;

                long long currMax = max({topMax, topMin, leftMax, leftMin});
                long long currMin = min({topMax, topMin, leftMax, leftMin});

                maxProd[col] = currMax;
                minProd[col] = currMin;
            }
        }

        long long result = maxProd[cols - 1];
        if (result < 0)
            return -1;
        return result % MOD;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<vector<int>> grid = {{1, 2}, {1, 3}};
    cout << sol.maxProductPath(grid) << endl;
}