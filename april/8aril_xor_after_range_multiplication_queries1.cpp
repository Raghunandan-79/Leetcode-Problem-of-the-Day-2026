#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int xorAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        const int MOD = 1e9 + 7;

        // Process each query
        for (int i = 0; i < queries.size(); i++) {
            int l = queries[i][0], r = queries[i][1], k = queries[i][2], v = queries[i][3];

            // Multiply elements at indices l, l+k, l+2k, ... up to r by v
            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (1LL * nums[idx] * v) % MOD;
            }
        }

        // Calculate XOR of all elements in the modified array
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            ans ^= nums[i];
        }

        return ans;
    }
};

// Driver code - this should not be submitted to LeetCode
int main() {
    Solution sol;
    vector<int> nums = {1, 2, 3, 4, 5};
    vector<vector<int>> queries = {{0, 4, 2, 2}, {1, 3, 1, 3}};
    cout << sol.xorAfterQueries(nums, queries) << endl; // Output the result
    return 0;
}