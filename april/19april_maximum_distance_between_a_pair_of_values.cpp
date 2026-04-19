#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxDistance(vector<int>& A, vector<int>& B) {
        int i, j = 1;

        for (i = 0; i < A.size() && j < B.size(); j++)
            i += A[i] > B[j];

        return j - i - 1;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    Solution sol;
    vector<int> A = {1, 2, 3};
    vector<int> B = {4, 5, 6};
    cout << sol.maxDistance(A, B) << endl; // Output: 2
    return 0;
}