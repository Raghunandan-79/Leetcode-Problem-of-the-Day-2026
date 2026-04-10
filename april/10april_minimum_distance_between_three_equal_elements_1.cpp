#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumDistance(vector<int>& nums) {
        int n = nums.size(), ans = INT_MAX; // initialize answer to a large value
        unordered_map<int, vector<int>> valueToIndex;

        for (int i = 0; i < n; i++)
            valueToIndex[nums[i]].push_back(i);

        for (auto& p : valueToIndex) {
            vector<int> indices = p.second;
            int s = indices.size();

            for (int i = 2; i < s; i++) { // We only process index lists that have at least 3 elements.
                int distance = 2 * (indices[i] - indices[i - 2]);
                ans = min(ans, distance);
            }
        }

        return (ans == INT_MAX) ? -1 : ans;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<int> nums = {1, 2, 3, 1, 2, 3, 1};
    cout << sol.minimumDistance(nums) << endl;
    return 0;
}