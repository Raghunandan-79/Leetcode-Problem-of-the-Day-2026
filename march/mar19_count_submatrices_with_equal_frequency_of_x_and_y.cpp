#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numberOfSubmatrices(vector<vector<char>>& grid) {
        // Get grid dimensions
        int m = grid.size(), n = grid[0].size();
        int ans = 0;

        // Prefix count arrays for X and Y in each column
        vector<int> px(n, 0), py(n, 0);

        // Iterate through each row
        for (int i = 0; i < m; i++) {
            int rowX = 0, rowY = 0;

            // Process each column in current row
            for (int j = 0; j < n; j++) {
                // Count X and Y in current row up to column j
                if (grid[i][j] == 'X')
                    rowX++;
                else if (grid[i][j] == 'Y')
                    rowY++;

                // Add row counts to column prefix arrays
                px[j] += rowX;
                py[j] += rowY;

                // If counts are equal and greater than 0, increment result
                if (px[j] == py[j] && px[j] > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    vector<vector<char>> grid = {
        {'X', 'Y'},
        {'Y', 'X'}
    };

    Solution sol;
    cout << sol.numberOfSubmatrices(grid) << endl;
}