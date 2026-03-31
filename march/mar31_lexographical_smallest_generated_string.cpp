#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool matches(const string& ans, int start, const string& str2) {
        for (int j = 0; j < str2.size(); j++) {
            if (ans[start + j] != str2[j])
                return false;
        }
        return true;
    }

    string generateString(string str1, string str2) {
        int n = str1.size();
        int m = str2.size();
        int L = n + m - 1;

        string ans(L, '?');
        vector<bool> fixed(L, false);

        // Step 1: Place str2 at positions where str1[i] == 'T'
        for (int i = 0; i < n; i++) {
            if (str1[i] == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    // Check for conflicts
                    if (ans[pos] != '?' && ans[pos] != str2[j]) {
                        return "";
                    }
                    ans[pos] = str2[j];
                    fixed[pos] = true;
                }
            }
        }

        // Step 2: Fill remaining '?' with 'a' (lexicographically smallest)
        for (int i = 0; i < L; i++) {
            if (ans[i] == '?')
                ans[i] = 'a';
        }

        // Step 3: Ensure str1[i] == 'F' positions don't match str2
        for (int i = 0; i < n; i++) {
            if (str1[i] == 'F') {
                if (matches(ans, i, str2)) {
                    // Try to change a non-fixed character to prevent match
                    bool changed = false;
                    for (int j = m - 1; j >= 0; j--) {
                        int pos = i + j;
                        if (!fixed[pos]) {
                            ans[pos] = (str2[j] == 'a' ? 'b' : 'a');
                            changed = true;
                            break;
                        }
                    }
                    if (!changed)
                        return "";
                }
            }
        }

        // Step 4: Validate the final answer
        for (int i = 0; i < n; i++) {
            bool eq = matches(ans, i, str2);
            if (str1[i] == 'T' && !eq)
                return "";
            if (str1[i] == 'F' && eq)
                return "";
        }

        return ans;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    string str1 = "TFFT", str2 = "ab";
    cout << sol.generateString(str1, str2) << endl; // Output: "
    return 0;
}