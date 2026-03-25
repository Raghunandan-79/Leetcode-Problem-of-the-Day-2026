#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    typedef long long ll;
    
    vector<vector<int>> constructProductMatrix(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size(), mod = 12345;

        // Initialize result matrix
        vector<vector<int>> ans(n, vector<int>(m));
        
        // Prefix product: store product of all elements before current position
        ll pref = 1;
        // Suffix product: store product of all elements after current position
        ll suff = 1;
        
        // Forward pass: calculate prefix products
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            ans[i][j] = pref;
            pref = (pref * grid[i][j]) % mod;
            }
        }
        
        // Backward pass: multiply suffix products and build final result
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
            ans[i][j] = (ans[i][j] * suff) % mod;
            suff = (suff * grid[i][j]) % mod;
            }
        }

        return ans;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<vector<int>> grid = {{1, 2}, {3, 4}};
    vector<vector<int>> result = sol.constructProductMatrix(grid);
    
    for (const auto& row : result) {
        for (int val : row) {
            cout << val << " ";
        }
        cout << endl;
    }

    return 0;
}