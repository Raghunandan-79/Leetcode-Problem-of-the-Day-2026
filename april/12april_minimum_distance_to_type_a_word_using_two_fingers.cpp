#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int dist(char a, char b) {
        int x1 = (a - 'A') / 6, y1 = (a - 'A') % 6;
        int x2 = (b - 'A') / 6, y2 = (b - 'A') % 6;
        return abs(x1 - x2) + abs(y1 - y2);
    }

    int minimumDistance(string word) {
        // dp[j] stores max saved distance if finger 1 is at letter j
        // Initially, no distance saved since no finger has moved yet
        vector<int> dp(26, 0);
        // total distance if we use only one finger (always move finger 1)
        int total = 0;

        // Process each pair of consecutive characters
        for (int i = 0; i < word.size() - 1; i++) {
            char a = word[i], b = word[i + 1];
            int d = dist(a, b);  // distance between consecutive chars
            total += d;  // add to total (cost if using only one finger)

            // newDp stores updated savings after typing character b
            vector<int> newDp(26, 0);

            // Try all possible positions for finger 2 (stored in j)
            for (int j = 0; j < 26; j++) {
                // Option 1: Keep same finger on letter j, no change in savings
                newDp[j] = max(newDp[j], dp[j]);

                // Option 2: Move finger 2 from position j to type character b
                // Calculate potential saving: previous saving + cost saved by using finger 2
                int saving = dp[j] + d - dist('A' + j, b);
                // Update savings when finger 1 is at position a (after typing b)
                newDp[a - 'A'] = max(newDp[a - 'A'], saving);
            }

            dp = newDp;
        }

        // Find maximum saving achievable with optimal finger positions
        int maxSaving = *max_element(dp.begin(), dp.end());
        
        // Subtract saved distance from total to get minimum distance
        return total - maxSaving;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    string word = "CAKE";
    Solution sol;
    cout << sol.minimumDistance(word) << "\n";
    return 0;
}