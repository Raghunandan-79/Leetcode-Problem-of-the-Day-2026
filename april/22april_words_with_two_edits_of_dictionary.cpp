#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<string> twoEditWords(vector<string>& queries, vector<string>& dictionary) {
        int n = queries[0].size();
        vector<string> ans;

        for (auto& it : queries) {
            for (auto& i : dictionary) {
                int diff = 0;
                
                for (int idx = 0; idx < n; idx++) {
                    if (it[idx] != i[idx]) {
                        diff++;
                    }
                    
                    if (diff > 2)
                        break;
                }
                
                if (diff <= 2) {
                    ans.push_back(it);
                    break;
                }
            }
        }
        
        return ans;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    vector<string> queries  = {"word", "note", "ants", "wood"};
    vector<string> dictionary = {"wood", "joke", "moat"};

    Solution sol;
    for (auto &it : sol.twoEditWords(queries, dictionary)) {
        cout << it << " ";
    }
    cout << "\n";

    return 0;
}