#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> reverseSubmatrix(vector<vector<int>>& grid, int x, int y, int k) {
        // Define the boundaries of the k x k submatrix
        int sc = y;           // start column
        int ec = y + k - 1;   // end column
        int sr = x;           // start row
        int er = x + k - 1;   // end row

        // Flip each column of the submatrix vertically
        for (int j = sc; j <= ec; j++) {
            // Swap elements from top and bottom of the column
            for (int i = 0; i < k / 2; i++) {
                swap(grid[sr + i][j], grid[sr + k - i - 1][j]);
            }
        }
        
        return grid;
    }
};


// Driver code - this should not be submitted to leetcode
int main() {
    Solution solution;
    vector<vector<int>> grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    vector<vector<int>> result = solution.reverseSubmatrix(grid, 0, 0, 2);

    for (const auto& row : result) {
        for (int val : row) {
            cout << val << " ";
        }
        cout << "\n";
    }

    return 0;
}