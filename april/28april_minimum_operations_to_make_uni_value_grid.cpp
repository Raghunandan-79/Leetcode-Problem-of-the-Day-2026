#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static int minOperations(vector<vector<int>>& grid, int x) {
        const int m = grid.size(), n = grid[0].size(), N = m * n;
        int freq[10001] = {0}, xMin = INT_MAX, xMax = 0;

        int r = grid[0][0] % x;
        for (const auto& row : grid) {
            for (int num : row) {
                auto [q, rr] = div(num, x);
                
                if (rr != r)
                    return -1; // If not consistent, return -1
                
                freq[q]++;
                xMax = max(xMax, q);
                xMin = min(xMin, q);
            }
        }
        
        int op = 0;
        for (int l = xMin, r = xMax; l < r;) {
            while (l < r && freq[l] == 0)
                l++;
            
            while (l < r && freq[r] == 0)
                r--;
            
            op += r - l;
            
            if (--freq[l] == 0)
                l++;
            
            if (--freq[r] == 0)
                r--;
        }

        return op;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<vector<int>> grid = {{2, 4}, {6, 8}};
    int x = 2;
    cout << sol.minOperations(grid, x) << endl; // Output: 4
    return 0;
}