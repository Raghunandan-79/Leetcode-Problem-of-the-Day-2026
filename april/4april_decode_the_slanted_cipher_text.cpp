#include <bits/stdc++.h>
using namespace std;

// variant using resize
class Solution {
public:
    static string decodeCiphertext(string& encodedText, int rows) {
        if (rows == 1)
            return encodedText;
        const int N = encodedText.size(), cols = N / rows;

        string dec;
        dec.reserve(N);
        for (int start = 0; start < cols; start++) {
            for (int r = 0, c = start; r < rows && c < cols; r++, c++) {
                dec.push_back(encodedText[r * cols + c]);
            }
        }
        
        int sz = dec.size();
        while (!dec.empty() && dec[sz - 1] == ' ')
            sz--;
        dec.resize(sz);

        return dec;
    }
};

// Driver code - this should not be submitted to leetcode
int main() {
    string encodedText = "ch   ie   pr";
    int rows = 3;
    cout << Solution::decodeCiphertext(encodedText, rows) << endl; // Output:
    return 0;
}