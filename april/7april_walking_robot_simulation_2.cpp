#include <bits/stdc++.h>
using namespace std;

class Robot {
private:
    // Grid width, height, perimeter length, and current perimeter index.
    int w, h, per, pos;
    // Tracks whether the robot has moved at least once.
    bool moved;

public:
    // Initialize robot at (0, 0), facing East, with perimeter-based movement.
    Robot(int width, int height) {
        w = width;
        h = height;
        per = 2 * (width + height - 2);
        pos = 0;
        moved = false;
    }

    // Move `num` steps along the border path (clockwise), wrapping by perimeter.
    void step(int num) {
        moved = true;
        pos = (pos + num) % per;
    }

    // Convert 1D perimeter index `pos` into 2D coordinates [x, y].
    vector<int> getPos() {
        int p = pos;
        
        // Bottom edge: (0,0) -> (w-1,0)
        if (p < w)
            return {p, 0};
        
        // Right edge: (w-1,1) -> (w-1,h-1)
        if (p < w + h - 1)
            return {w - 1, p - (w - 1)};
        
        // Top edge: (w-2,h-1) -> (0,h-1)
        if (p < 2 * w + h - 2)
            return {(w - 1) - (p - (w + h - 2)), h - 1};
        
        // Left edge: (0,h-2) -> (0,1)
        return {0, per - p};
    }

    // Return current facing direction based on perimeter index.
    string getDir() {
        int p = pos;
        
        // At origin: initial state faces East; after any move and wrap, faces South.
        if (p == 0)
            return moved ? "South" : "East";
        
        // Bottom edge movement direction.
        if (p < w)
            return "East";
        
        // Right edge movement direction.
        if (p < w + h - 1)
            return "North";
        
        // Top edge movement direction.
        if (p < 2 * w + h - 2)
            return "West";

        // Left edge movement direction.
        return "South";
    }
};

/**
 * Your Robot object will be instantiated and called as such:
 * Robot* obj = new Robot(width, height);
 * obj->step(num);
 * vector<int> param_2 = obj->getPos();
 * string param_3 = obj->getDir();
 */

// Driver code - this should not be submitted to leetcode
int main() {
    Robot* obj = new Robot(6, 3);
    obj->step(2);
    vector<int> param_2 = obj->getPos();
    string param_3 = obj->getDir();

    cout << "Position: [" << param_2[0] << ", " << param_2[1] << "]\n";
    cout << "Direction: " << param_3 << "\n";

    return 0; 
} 