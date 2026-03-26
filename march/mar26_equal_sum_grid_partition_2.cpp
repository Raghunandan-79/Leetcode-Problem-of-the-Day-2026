#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canPartitionGrid(vector<vector<int>> &grid) {
        int n = grid.size();
        int m = grid[0].size();

        long long tot = 0;
        unordered_map<long long, long long> mpp1, mpp2;

        // Calculate total sum and store all elements in mpp2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mpp2[grid[i][j]]++;
                tot += grid[i][j];
            }
        }

        long long left = 0, right = 0, down = 0, up = 0;

        // Handle single row case
        if (n == 1) {
            for (int j = 0; j < m - 1; j++) {
                left += grid[0][j];
                long long right = tot - left;

                // Check if partitions are already equal
                if (right == left)
                    return true;

                long long diff;

                // Check if difference can be balanced by a single element
                if (right > left) {
                    diff = right - left;
                    if (grid[0][j + 1] == diff || grid[0][m - 1] == diff)
                        return true;
                }
                else {
                    diff = left - right;
                    if (grid[0][0] == diff || grid[0][j] == diff)
                        return true;
                }
            }

            return false;
        }

        // Handle single column case
        if (m == 1) {
            for (int i = 0; i < n - 1; i++) {
                up += grid[i][0];
                long long down = tot - up;

                if (down == up)
                    return true;

                long long diff;

                if (down > up) {
                    diff = down - up;
                    if (grid[i + 1][0] == diff || grid[n - 1][0] == diff)
                        return true;
                }
                else {
                    diff = up - down;
                    if (grid[i][0] == diff || grid[0][0] == diff)
                        return true;
                }
            }

            return false;
        }

        // Try horizontal cuts (row-wise partition)
        down = 0;
        up = 0;

        for (int i = 0; i < n - 1; i++) {
            // Add current row to upper partition
            for (int j = 0; j < m; j++) {
                up += grid[i][j];
                mpp1[grid[i][j]]++;
                mpp2[grid[i][j]]--;

                if (mpp2[grid[i][j]] == 0)
                    mpp2.erase(grid[i][j]);
            }

            down = tot - up;
            long long diff;

            if (down == up)
                return true;
            else if (down > up) {
                diff = down - up;

                // Check if difference exists in lower partition
                if (mpp2.find(diff) != mpp2.end()) {
                    // Skip if at last row, must be corner element
                    if (i == n - 2) {
                        if (diff == grid[n - 1][0] ||
                            diff == grid[n - 1][m - 1])
                            return true;
                        else
                            continue;
                    }

                    return true;
                }
            }
            else {
                diff = up - down;

                // Check if difference exists in upper partition
                if (mpp1.find(diff) != mpp1.end()) {
                    // Skip if at first row, must be corner element
                    if (i == 0) {
                        if (diff == grid[0][0] || diff == grid[0][m - 1])
                            return true;
                        else
                            continue;
                    }

                    return true;
                }
            }
        }

        // Try vertical cuts (column-wise partition)
        left = 0;
        right = 0;
        mpp1.clear();
        mpp2.clear();
        // Reinitialize mpp2 with all elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mpp2[grid[i][j]]++;
            }
        }

        for (int j = 0; j < m - 1; j++) {
            // Add current column to left partition
            for (int i = 0; i < n; i++) {
                left += grid[i][j];
                mpp1[grid[i][j]]++;
                mpp2[grid[i][j]]--;

                if (mpp2[grid[i][j]] == 0)
                    mpp2.erase(grid[i][j]);
            }

            right = tot - left;
            long long diff;

            if (right == left)
                return true;
            else if (right > left) {
                diff = right - left;

                // Check if difference exists in right partition
                if (mpp2.find(diff) != mpp2.end()) {
                    // Skip if at last column, must be corner element
                    if (j == m - 2) {
                        if (diff == grid[0][m - 1] ||
                            diff == grid[n - 1][m - 1])
                            return true;
                        else
                            continue;
                    }

                    return true;
                }
            }
            else {
                diff = left - right;

                // Check if difference exists in left partition
                if (mpp1.find(diff) != mpp1.end()) {
                    // Skip if at first column, must be corner element
                    if (j == 0) {
                        if (diff == grid[0][0] || diff == grid[n - 1][0])
                            return true;
                        else
                            continue;
                    }
                    return true;
                }
            }
        }

        return false;
    }
};

// Driver code - this should not be submitted to leetcode
int main(){
    Solution sol;
    vector<vector<int>> grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    cout << sol.canPartitionGrid(grid) << endl; // Output: 1 (true)
    return 0;
}