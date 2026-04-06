#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        // dir represents current direction
        // 0 = North, 1 = East, 2 = South, 3 = West
        int dir = 0;

        // Store obstacles for quick lookup
        map<pair<int, int>, bool> mp;
        for (auto it : obstacles) {
            mp[{it[0], it[1]}] = true;
        }

        // Current position of robot
        int x = 0, y = 0;

        // Maximum distance squared from origin
        int ans = 0;

        for (auto it : commands) {
            // Handle turning commands
            if (it < 0) {
                if (it == -1)
                    dir = (dir + 1) % 4; // turn right
                else
                    dir = (dir - 1 + 4) % 4; // turn left
            }
            // Handle forward movement
            else {
                // Moving North
                if (dir == 0) {
                    int maxi = y + it;

                    // Move step-by-step until obstacle or limit reached
                    while (y < maxi && !mp[{x, y + 1}])
                        y++;
                }
                // Moving East
                else if (dir == 1) {
                    int maxi = x + it;

                    while (x < maxi && !mp[{x + 1, y}])
                        x++;
                }
                // Moving South
                else if (dir == 2) {
                    int mini = y - it;

                    while (y > mini && !mp[{x, y - 1}])
                        y--;
                }
                // Moving West
                else if (dir == 3) {
                    int mini = x - it;

                    while (x > mini && !mp[{x - 1, y}])
                        x--;
                }

                // Update maximum squared distance
                ans = max(ans, x * x + y * y);
            }
        }

        return ans;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<int> commands = {4, -1, 3};
    vector<vector<int>> obstacles = {};
    cout << sol.robotSim(commands, obstacles) << endl; // Output: 25
    return 0;
}