#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countSubmatrices(vector<vector<int>>& grid, int k) {
        int m = grid.size(), n = grid[0].size();
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long long up = (i > 0 ? grid[i - 1][j] : 0);
                long long left = (j > 0 ? grid[i][j - 1] : 0);
                long long diag = (i > 0 && j > 0 ? grid[i - 1][j - 1] : 0);

                grid[i][j] = grid[i][j] + up + left - diag;

                if (grid[i][j] <= k) {
                    ans++;
                } 
                else {
                    if (j == 0)
                        return ans;
                    break;
                }
            }
        }

        return ans;
    }
};


// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<vector<int>> grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int k = 10;
    cout << sol.countSubmatrices(grid, k) << endl; // Output: 4
    return 0;
}