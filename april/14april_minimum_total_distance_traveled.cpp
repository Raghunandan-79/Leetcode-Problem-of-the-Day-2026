#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long minimumTotalDistance(vector<int>& r, vector<vector<int>>& f) {
        sort(r.begin(), r.end());
        sort(f.begin(), f.end());

        int n = r.size();
        vector<long long> dp(n + 1, -1);
        dp[0] = 0;

        for (auto& fac : f) {
            int pos = fac[0];
            int cap = fac[1];

            vector<long long> prev = dp;

            for (int i = 0; i <= n; i++) {
                if (prev[i] == -1)
                    break;

                long long cost = prev[i];

                for (int k = 1; k <= cap; k++) {
                    if (i + k > n)
                        break;

                    cost += abs(r[i + k - 1] - pos);

                    if (dp[i + k] == -1 || cost < dp[i + k]) {
                        dp[i + k] = cost;
                    }
                }
            }
        }

        return dp[n];
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<int> r = {1, 2, 3};
    vector<vector<int>> f = {{2, 2}, {3, 1}};
    cout << sol.minimumTotalDistance(r, f) << endl; // Output: 2
    return 0;
}