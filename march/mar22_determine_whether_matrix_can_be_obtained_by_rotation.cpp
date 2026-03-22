#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {
        int n = mat.size();
        
        // Try up to 4 rotations (0°, 90°, 180°, 270°)
        for (int r = 0; r < 4; r++) {
            // Rotate matrix 90 degrees clockwise
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    // Store top-left element
                    int temp = mat[i][j];
                    
                    // Move left -> top, bottom -> left, right -> bottom, top -> right
                    mat[i][j] = mat[n - 1 - j][i];
                    mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
                    mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
                    mat[j][n - 1 - i] = temp;
                }
            }

            // Check if current rotation matches target
            if (mat == target) return true;
        }

        // No rotation matched the target
        return false;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution solution;
    vector<vector<int>> mat = {{0, 1}, {1, 0}};
    vector<vector<int>> target = {{1, 0}, {0, 1}};
    cout << (solution.findRotation(mat, target) ? "true" : "false") << endl;
    return 0;
}