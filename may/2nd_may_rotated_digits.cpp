#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isGood(int n) {
        int f = false, s = false;
        
        while (n > 0) {
            int ld = n % 10;

            if (ld == 3 || ld == 4 || ld == 7)
                f = true;

            if (ld == 2 || ld == 5 || ld == 6 || ld == 9)
                s = true; 

            n /= 10;
        }
        
        if (f)
            return false;
        else if (s)
            return true;
        
        return false;
    }

    int rotatedDigits(int n) {
        int ans = 0;
        
        for (int i = 1; i <= n; i++) {
            if (isGood(i))
                ans++;
        }
        
        return ans;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    int n = 10;
    cout << sol.rotatedDigits(n) << endl; // Output the count of good numbers
    return 0;
}