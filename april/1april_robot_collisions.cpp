#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> survivedRobotsHealths(vector<int>& positions,
                                      vector<int>& healths, string directions) {
        int n = positions.size();
        // Create index array to track original positions
        std::vector<int> index(n);

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        
        // Sort robots by position (left to right)
        std::sort(index.begin(), index.end(), [&positions](int a, int b) {
            return positions[a] < positions[b];
        });
        
        // Stack to track robots moving right that may collide
        std::vector<int> stack;
        
        // Process robots in order of position
        for (int i : index) {
            if (directions[i] == 'R') {
                // Robot moving right - add to stack
                stack.push_back(i);
                continue;
            }
            
            // Robot moving left - check collisions with robots moving right
            while (!stack.empty() && healths[i] > 0) {
                if (healths[stack.back()] < healths[i]) {
                    // Left-moving robot wins
                    healths[stack.back()] = 0;
                    stack.pop_back();
                    healths[i] -= 1;
                } else if (healths[stack.back()] > healths[i]) {
                    // Right-moving robot wins
                    healths[stack.back()] -= 1;
                    healths[i] = 0;
                } else {
                    // Both robots destroyed in collision
                    healths[stack.back()] = 0;
                    healths[i] = 0;
                    stack.pop_back();
                }
            }
        }
        
        // Collect surviving robots
        std::vector<int> result;
        
        for (int h : healths) {
            if (h > 0) {
                result.push_back(h);
            }
        }

        return result;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<int> positions = {1, 2, 3, 4};
    vector<int> healths = {10, 20, 30, 40};
    string directions = "RLRL";
    
    vector<int> result = sol.survivedRobotsHealths(positions, healths, directions);
    
    for (int h : result) {
        cout << h << " ";
    }
    cout << endl;
    
    return 0;
}