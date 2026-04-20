#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxDistance(vector<int>& colors) {
        const int n = colors.size();
        int c0 = colors[0], cN = colors[n - 1];
        int lMax = 0, rMax = 0;

        for (int i = 0; i < n; i++) {
            int c = colors[i];
            lMax += (-((c0 != c) & (i > lMax))) & (i - lMax);
            rMax += (-((cN != c) & (i > rMax))) & (n - 1 - i - rMax);
        }
        
        return max(lMax, rMax);
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<int> colors = {1, 1, 1, 6, 1, 1, 1};
    cout << sol.maxDistance(colors) << endl; // Output: 3
    return 0;
}