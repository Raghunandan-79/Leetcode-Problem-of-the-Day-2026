#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> parent;

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void unite(int a, int b) { parent[find(a)] = find(b); }

    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        int n = source.size();
        parent.resize(n);
        iota(parent.begin(), parent.end(), 0);

        for (auto& swap : allowedSwaps) {
            unite(swap[0], swap[1]);
        }

        // Group source values by their component root
        unordered_map<int, unordered_map<int, int>> groups;
        for (int i = 0; i < n; i++) {
            groups[find(i)][source[i]]++;
        }

        int hammingDist = 0;
        
        for (int i = 0; i < n; i++) {
            int root = find(i);
            auto& freq = groups[root];

            if (freq.count(target[i]) && freq[target[i]] > 0) {
                freq[target[i]]--; // matched, consume this source value
            } else {
                hammingDist++; // no match found in this component
            }
        }

        return hammingDist;
    }
};

// Driver code - this code should not be submmitted to LeetCode
int main() {
    Solution sol;
    vector<int> source = {1, 2, 3, 4};
    vector<int> target = {2, 1, 4, 5};
    vector<vector<int>> allowedSwaps = {{0, 1}, {2, 3}};
    cout << sol.minimumHammingDistance(source, target, allowedSwaps) << endl; // Output: 1
    return 0;
}