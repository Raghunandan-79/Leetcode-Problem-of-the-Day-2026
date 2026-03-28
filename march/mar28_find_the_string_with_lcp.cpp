#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string findTheString(vector<vector<int>>& lcp) {
        int n = lcp.size();
        string word(n, '\0');
        char current = 'a';

        // First pass: assign characters to unassigned positions based on LCP values
        for (int i = 0; i < n; i++) {
            if (word[i] == '\0') {
                // Check if we have exhausted the alphabet
                if (current > 'z') {
                    return "";
                }
                
                // Assign current character to position i
                word[i] = current;
                
                // Assign same character to positions j where lcp[i][j] > 0
                for (int j = i + 1; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        word[j] = word[i];
                    }
                }
                
                current++;
            }
        }

        // Second pass: validate the constructed string against the LCP matrix
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] != word[j]) {
                    // Different characters must have LCP value of 0
                    if (lcp[i][j]) {
                        return "";
                    }
                } else {
                    // Same characters: check LCP constraints
                    if (i == n - 1 || j == n - 1) {
                        // At boundary: LCP must be 1
                        if (lcp[i][j] != 1) {
                            return "";
                        }
                    } else {
                        // Not at boundary: LCP must be 1 + LCP of next positions
                        if (lcp[i][j] != lcp[i + 1][j + 1] + 1) {
                            return "";
                        }
                    }
                }
            }
        }

        return word;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<vector<int>> lcp = {
        {3, 2, 1},
        {2, 2, 1},
        {1, 1, 1}
    };
    cout << sol.findTheString(lcp) << endl; // Output: "abc"
    return 0;
}