#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumDistance(vector<int>& nums) {
        unordered_map<int, vector<int>> mp;
        int n = nums.size();

        // store indices
        for (int i = 0; i < n; i++) {
            mp[nums[i]].push_back(i);
        }

        int mini = INT_MAX;

        // process each element
        for (int i = 0; i < n; i++) {
            if (mp.find(nums[i]) != mp.end()) {
                // for reference and not a copy of list
                vector<int>& list = mp[nums[i]];

                if (list.size() >= 3) {
                    for (int j = 1; j < list.size() - 1; j++) {
                        int t = abs(list[j - 1] - list[j]) +
                                abs(list[j + 1] - list[j]);
                        t *= 2;
                        mini = min(mini, t);
                    }
                }

                // remove processed index
                mp.erase(nums[i]);
            }
        }

        return mini == INT_MAX ? -1 : mini;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<int> nums = {1, 2, 3, 1, 1, 3};
    cout << sol.minimumDistance(nums) << endl; // Output: 4
    return 0;
}