#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int mirrorDistance(int n) {
        // Preserve the original number for later comparison.
        int copy = n;
        // Store the reversed form of the number.
        int rev = 0;

        // Build the reversed number digit by digit.
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        
        // Mirror distance is the absolute difference between
        // the original number and its reversed number.
        return abs(rev - copy);
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    int n = 123;
    cout << sol.mirrorDistance(n) << endl; // Output should be 198,
    return 0;
}