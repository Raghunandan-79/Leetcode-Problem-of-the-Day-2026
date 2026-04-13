#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int getMinDistance(vector<int>& nums, int target, int start) {
        // Initialize left and right pointers starting from 'start' position
        int left = start, right = start;
        // Initialize minimum distance to maximum possible value
        int mini = INT_MAX;

        // Search leftwards from start position
        while (left >= 0) {
            if (nums[left] == target) {
                // Calculate distance: start - left (left is <= start)
                mini = min(mini, start - left);
            }

            left--;
        }

        // Search rightwards from start position
        while (right < nums.size()) {
            if (nums[right] == target) {
                // Calculate distance: right - start (right is >= start)
                mini = min(mini, right - start);
            }

            right++;
        }
        
        // Return the minimum distance found
        return mini;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<int> nums = {1, 2, 3, 4, 5};
    int target = 5;
    int start = 3;
    cout << sol.getMinDistance(nums, target, start) << endl; // Output: 1
    return 0;
}