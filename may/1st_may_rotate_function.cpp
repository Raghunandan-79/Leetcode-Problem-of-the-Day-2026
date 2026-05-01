#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static int maxRotateFunction(vector<int>& nums) {
        const int n = nums.size();
        int Sum = 0, F = 0;

        for (int i = 0; i < n; i++) {
            const int x = nums[i];
            Sum += x;
            F += i * x;
        }
        
        int ans = F;
        
        for (int k = 1; k < n; k++) {
            F += Sum - n * nums[n - k];
            ans = max(ans, F);
        }
        
        return ans;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<int> nums = {4, 3, 2, 6};
    cout << sol.maxRotateFunction(nums) << endl; // Output the maximum rotate function value
    return 0;
}