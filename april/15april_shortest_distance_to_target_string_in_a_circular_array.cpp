#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static int closestTarget(vector<string>& words, string& target, int startIndex) {
        const int n = words.size();
        int d = 0;

        // Search outward from startIndex, checking both left and right directions
        for (; d <= n - 1; d++) {
            // Calculate left index with wrap-around (circular)
            const int l = startIndex >= d ? startIndex - d : n + startIndex - d;
            // Calculate right index with wrap-around (circular)
            const int r = startIndex + d >= n ? startIndex + d - n : startIndex + d;
            
            const string& x = words[l];
            const string& y = words[r];
            
            // If either direction reaches the target, return the distance
            if (x == target || y == target)
                return d;
        }

        // Target not found in the circular array
        return -1;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    vector<string> words = {"hello", "i", "am", "leetcode", "hello"};
    string target = "hello";
    int startIndex = 1;
    cout << Solution::closestTarget(words, target, startIndex) << endl; // Output: 1
    return 0;
}