#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool judgeCircle(string moves) {
        // Track how many steps are taken in each direction.
        int r = 0, l = 0, u = 0, d = 0;
        int n = moves.size(); // Total number of moves (optional, not used below).

        // Count each move character.
        for (char& i : moves) {
            if (i == 'R') r++;          // Move right
            else if (i == 'L') l++;     // Move left
            else if (i == 'U') u++;     // Move up
            else d++;                   // Move down ('D')
        }

        // Robot returns to origin if horizontal and vertical moves cancel out.
        if (r == l && u == d) 
            return true;
        else 
            return false;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    string moves = "UD";
    cout << sol.judgeCircle(moves) << endl; // Output: true
    return 0;
}