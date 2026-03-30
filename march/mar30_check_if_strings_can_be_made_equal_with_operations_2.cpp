#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static bool checkStrings(string& s1, string& s2) {
        // Frequency array: indices 0-25 for even positions, 26-51 for odd positions
        array<int, 52> freq{};
        const int n = s1.size();

        // Process each character pair at the same position
        for (int i = 0; i < n; i++) {
            bool iOdd = i & 1;  // Check if index is odd
            // Increment frequency for s1 character at current position parity
            freq[iOdd * 26 + s1[i] - 'a']++;
            // Decrement frequency for s2 character at current position parity
            freq[iOdd * 26 + s2[i] - 'a']--;
        }

        // Strings are equal if all frequency counts are zero
        return all_of(freq.begin(), freq.end(), [](int x) { return x == 0; });
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    string s1 = "abcd", s2 = "cdab";
    cout << sol.checkStrings(s1, s2) << endl; // Output:
    return 0;
}