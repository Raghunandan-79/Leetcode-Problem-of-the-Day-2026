#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canBeEqual(string s1, string s2) {
        // Extract characters at even and odd indices from both strings
        string even1 = "", odd1 = "";
        string even2 = "", odd2 = "";
        
        // Separate characters by their index parity
        for(int i = 0; i < s1.size(); i++) {
            if(i % 2 == 0) {
                even1 += s1[i];
                even2 += s2[i];
            } else {
                odd1 += s1[i];
                odd2 += s2[i];
            }
        }
        
        // Sort all extracted substrings to enable comparison
        sort(even1.begin(), even1.end());
        sort(even2.begin(), even2.end());
        sort(odd1.begin(), odd1.end());
        sort(odd2.begin(), odd2.end());
        
        // Check if sorted even and odd substrings are equal
        return even1 == even2 && odd1 == odd2;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    string s1 = "abcd", s2 = "cdab";
    cout << sol.canBeEqual(s1, s2) << endl; // Output: 1 (true)
    
    s1 = "abc", s2 = "bca";
    cout << sol.canBeEqual(s1, s2) << endl; // Output: 0 (false)
    return 0;
}