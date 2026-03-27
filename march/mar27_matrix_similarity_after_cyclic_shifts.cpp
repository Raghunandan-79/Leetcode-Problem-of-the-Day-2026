#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool areSimilar(vector<vector<int>>& mat, int k) {
        int m = mat.size(); // Number of rows
        int n = mat[0].size(); // Number of columns
        k %= n; // Effective shift amount

        // Iterate through each cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i % 2 == 0) { // even row → left shift
                    // Check if element matches its counterpart after left shift
                    if (mat[i][j] != mat[i][(j + k) % n])
                        return false;
                } else { // odd row → right shift
                    // Check if element matches its counterpart after right shift
                    if (mat[i][j] != mat[i][(j - k + n) % n])
                        return false;
                }
            }
        }

        return true;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<vector<int>> mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int k = 2;
    cout << (sol.areSimilar(mat, k) ? "true" : "false") << endl;
    return 0;
}