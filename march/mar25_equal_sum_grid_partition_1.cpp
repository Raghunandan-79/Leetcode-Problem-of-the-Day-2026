#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canPartitionGrid(vector<vector<int>>& grid) {
        // Get grid dimensions
        int m = grid.size(), n = grid[0].size();

        // Arrays to store sum of each row and column
        vector<long long> rowSum(m, 0), colSum(n, 0);
        long long total = 0;

        // Calculate row sums, column sums, and total grid sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
                total += grid[i][j];
            }
        }

        // If total sum is odd, equal partition is impossible
        if (total % 2)
            return false;

        // Check if rows can be partitioned into equal sum groups
        if (check(rowSum, total))
            return true;

        // Check if columns can be partitioned into equal sum groups
        if (check(colSum, total))
            return true;

        // No valid partition found
        return false;
    }

    bool check(vector<long long>& arr, long long total) {
        // Initialize left sum with first element and right sum with remaining
        long long left = arr[0];
        long long right = total - left;

        // Iterate through remaining elements to find partition point
        for (int i = 1; i < arr.size(); i++) {
            // Check if we found equal partition
            if (left == right) return true;
            // If left is already greater, partition is impossible
            else if (left > right) return false;
            
            // Move to next element: add to left, remove from right
            left += arr[i];
            right -= arr[i];
        }

        // No valid partition found
        return false;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<vector<int>> grid = {{1, 2}, {3, 4}};
    bool result = sol.canPartitionGrid(grid);
    cout << (result ? "true" : "false") << endl;
    return 0;
}