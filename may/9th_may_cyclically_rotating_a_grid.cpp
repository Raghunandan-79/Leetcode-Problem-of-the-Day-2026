#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void rotateArray(vector<int>& arr, int k) {
        int n = arr.size();
        k = k % n;

        reverse(arr.begin(), arr.begin() + k);
        reverse(arr.begin() + k, arr.end());
        reverse(arr.begin(), arr.end());
    }
    
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int K) {
        int n = grid.size();
        int m = grid[0].size();

        for (int k = 0; k < min(n / 2, m / 2); k++) {
            int row_st = k;
            int row_end = n - k - 1;
            int col_st = k;
            int col_end = m - k - 1;
            vector<int> helper;

            // left to right
            for (int j = col_st; j <= col_end; j++) {
                helper.push_back(grid[row_st][j]);
            }

            // top to bottom
            for (int i = row_st + 1; i <= row_end; i++) {
                helper.push_back(grid[i][col_end]);
            }

            // right to left
            for (int j = col_end - 1; j >= col_st; j--) {
                helper.push_back(grid[row_end][j]);
            }

            // bottom to top
            for (int i = row_end - 1; i >= row_st + 1; i--) {
                helper.push_back(grid[i][col_st]);
            }

            rotateArray(helper, K);

            int ind = 0;

            // left to right
            for (int j = col_st; j <= col_end; j++) {
                grid[row_st][j] = helper[ind++];
            }

            // top to bottom
            for (int i = row_st + 1; i <= row_end; i++) {
                grid[i][col_end] = helper[ind++];
            }

            // right to left
            for (int j = col_end - 1; j >= col_st; j--) {
                grid[row_end][j] = helper[ind++];
            }

            // bottom to top
            for (int i = row_end - 1; i >= row_st + 1; i--) {
                grid[i][col_st] = helper[ind++];
            }
        }

        return grid;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<vector<int>> grid = {{40, 10}, {30, 20}};
    int K = 1;
    
    vector<vector<int>> result = sol.rotateGrid(grid, K);
    for (const auto& row : result) {
        for (int val : row) {
            cout << val << " ";
        }
        cout << endl;
    }
    
    return 0;
}