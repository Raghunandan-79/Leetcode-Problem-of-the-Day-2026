#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> minAbsDiff(vector<vector<int>>& grid, int k) {
        // Get grid dimensions
        int m = grid.size();
        int n = grid[0].size();
        
        // Initialize result matrix for all k×k submatrices
        vector<vector<int>> ans(m - k + 1, vector<int>(n - k + 1));

        // Iterate through all possible k×k submatrix positions
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                vector<int> v;

                // Extract all elements from current k×k submatrix
                for (int x = i; x < i + k; x++)
                    for (int y = j; y < j + k; y++)
                        v.push_back(grid[x][y]);

                // Sort elements and remove duplicates
                sort(v.begin(), v.end());
                v.erase(unique(v.begin(), v.end()), v.end());

                // If 0 or 1 unique elements, minimum difference is 0
                if (v.size() <= 1) {
                    ans[i][j] = 0;
                } 
                else {
                    // Find minimum absolute difference between consecutive sorted elements
                    int mn = INT_MAX;
                    
                    for (int p = 0; p < (int)v.size() - 1; p++)
                        mn = min(mn, v[p + 1] - v[p]);
                    
                    ans[i][j] = mn;
                }
            }
        }

        return ans;
    }
};

int main() {
    Solution sol;
    vector<vector<int>> grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int k = 2;
    vector<vector<int>> result = sol.minAbsDiff(grid, k);

    for (auto& row : result) {
        for (int val : row) {
            cout << val << " ";
        }
        cout << "\n";
    }

    return 0;
}