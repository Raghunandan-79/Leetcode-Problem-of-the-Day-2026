#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int dfs(int i, int j, int pi, int pj, vector<vector<char>>& grid, vector<vector<int>>& isvisited, int r, int c) {
        isvisited[i][j] = 1;

        // up
        if ((i - 1) >= 0 && grid[i - 1][j] == grid[i][j]) {
            if (isvisited[i - 1][j] == 0) {
                if (dfs(i - 1, j, i, j, grid, isvisited, r, c))
                    return 1;
            } else if (i - 1 != pi || j != pj) {
                return 1;
            }
        }

        // down
        if ((i + 1) < r && grid[i + 1][j] == grid[i][j]) {
            if (isvisited[i + 1][j] == 0) {
                if (dfs(i + 1, j, i, j, grid, isvisited, r, c))
                    return 1;
            } else if (i + 1 != pi || j != pj) {
                return 1;
            }
        }

        // left
        if ((j - 1) >= 0 && grid[i][j - 1] == grid[i][j]) {
            if (isvisited[i][j - 1] == 0) {
                if (dfs(i, j - 1, i, j, grid, isvisited, r, c))
                    return 1;
            } else if (i != pi || j - 1 != pj) {
                return 1;
            }
        }

        // right
        if ((j + 1) < c && grid[i][j + 1] == grid[i][j]) {
            if (isvisited[i][j + 1] == 0) {
                if (dfs(i, j + 1, i, j, grid, isvisited, r, c))
                    return 1;
            } else if (i != pi || j + 1 != pj) {
                return 1;
            }
        }

        return 0;
    }

    bool containsCycle(vector<vector<char>>& grid) {
        // Get grid dimensions
        int rows = grid.size(), cols = grid[0].size();

        // Visited matrix to track cells already explored by DFS
        vector<vector<int>> isvisited(rows, vector<int>(cols, 0));

        // Try starting DFS from every unvisited cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start a new DFS traversal only if current cell is unvisited
                if (isvisited[i][j] == 0) {
                    // Parent coordinates are (-1, -1) for the starting node
                    int temp = dfs(i, j, -1, -1, grid, isvisited, rows, cols);
                    
                    // If DFS detects a cycle, return true immediately
                    if (temp == 1) {
                        return true;
                    }
                }
            }
        }

        // No cycle found in any connected component
        return false;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<vector<char>> grid = {
        {'a', 'a', 'a', 'a'},
        {'a', 'b', 'b', 'a'},
        {'a', 'b', 'b', 'a'},
        {'a', 'a', 'a', 'a'}
    };

    cout << sol.containsCycle(grid) << endl; // Output: true
    return 0;
}