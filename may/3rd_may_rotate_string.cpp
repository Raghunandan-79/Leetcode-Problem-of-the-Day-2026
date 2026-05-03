#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool rotateString(string s, string goal) {
        if (s.size() != goal.size()) return false;
        
        string doubled_s = s + s;
        return doubled_s.find(goal) != string::npos;
    }
};

// Driver code
int main() {
    Solution sol;
    string s = "abcde";
    string goal = "cdeab";
    
    bool result = sol.rotateString(s, goal);
    cout << (result ? "True" : "False") << endl; // Output: True
    
    return 0;
}