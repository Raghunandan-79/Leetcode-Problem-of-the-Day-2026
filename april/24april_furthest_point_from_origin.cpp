#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        // x stores the current net displacement from origin.
        // r stores the number of flexible moves ('_') that can be assigned as needed.
        int x = 0, r = 0;

        for (char c : moves) {
            // Update displacement: +1 for 'R', -1 for 'L', 0 for '_'.
            x += (c == 'R') - (c == 'L');
            // Count undecided moves that can increase final distance.
            r += c == '_';
        }
        
        // Maximum possible distance = current absolute displacement + all flexible moves.
        return abs(x) + r;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    string moves = "R_L_";
    cout << sol.furthestDistanceFromOrigin(moves) << endl; // Output:
    return 0;
}