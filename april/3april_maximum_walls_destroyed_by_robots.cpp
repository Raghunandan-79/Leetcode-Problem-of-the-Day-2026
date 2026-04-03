#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxWalls(vector<int>& robots, vector<int>& distance,
                 vector<int>& walls) {
        int n = robots.size();
        vector<pair<int, int>> r(n);
        for (int i = 0; i < n; i++)
            r[i] = {robots[i], distance[i]};

        // Sort to process linearly and use binary search on walls
        sort(r.begin(), r.end());
        sort(walls.begin(), walls.end());

        // Helper function to count unique walls in range [a, b]
        auto countWalls = [&](long long a, long long b) {
            if (a > b)
                return 0;
            auto it1 = lower_bound(walls.begin(), walls.end(), a);
            auto it2 = upper_bound(walls.begin(), walls.end(), b);
            return (int)(it2 - it1);
        };

        vector<vector<int>> dp(n, vector<int>(2, 0));

        // Base Case: First robot
        dp[0][0] = countWalls((long long)r[0].first - r[0].second, r[0].first);
        int limit0 = (n > 1) ? r[1].first - 1 : 2e9;
        dp[0][1] =
            countWalls(r[0].first, min((long long)r[0].first + r[0].second,
                                       (long long)limit0));

        for (int i = 1; i < n; i++) {
            long long curr_p = r[i].first;
            long long curr_d = r[i].second;
            long long prev_p = r[i - 1].first;
            long long prev_d = r[i - 1].second;

            // Scenario 1: Current robot fires LEFT
            long long left_reach = max(prev_p + 1, curr_p - curr_d);
            int walls_i_left = countWalls(left_reach, curr_p);

            // If prev fired LEFT, no overlap possible
            int from_prev_left = dp[i - 1][0] + walls_i_left;

            // If prev fired RIGHT, subtract overlapping walls to avoid double
            // counting
            long long prev_right_reach = min(curr_p - 1, prev_p + prev_d);
            int overlap = countWalls(left_reach, prev_right_reach);
            int from_prev_right = dp[i - 1][1] + (walls_i_left - overlap);

            dp[i][0] = max(from_prev_left, from_prev_right);

            // Scenario 2: Current robot fires RIGHT
            long long right_lim = (i == n - 1) ? 2e9 : r[i + 1].first - 1;
            int walls_i_right =
                countWalls(curr_p, min(curr_p + curr_d, right_lim));

            // Firing right doesn't conflict with any choice of the previous
            // robot
            dp[i][1] = max(dp[i - 1][0], dp[i - 1][1]) + walls_i_right;
        }

        return max(dp[n - 1][0], dp[n - 1][1]);
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<int> robots = {1, 4, 6};
    vector<int> distance = {2, 1, 3};
    vector<int> walls = {2, 3, 5, 7};
    cout << sol.maxWalls(robots, distance, walls) << endl; // Expected output
    return 0;
}