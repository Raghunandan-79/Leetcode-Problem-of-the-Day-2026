package january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Jan14SeparateSquares2 {
    class Solution {
        // Event class to represent horizontal lines of squares
        static class Event {
            double y;      // y-coordinate of the event
            double x1, x2; // x-range of the square edge
            int type;      // 1 for top edge, -1 for bottom edge
            
            Event(double y, double x1, double x2, int type) {
                this.y = y; this.x1 = x1; this.x2 = x2; this.type = type;
            }
        }

        double[] xs;    // Sorted unique x-coordinates
        int[] cnt;      // Segment tree node count array
        double[] seg;   // Segment tree node length array

        // Segment tree update to track covered length at each level
        void update(int node, int l, int r, int ql, int qr, int val) {
            if (qr <= l || r <= ql) return; // No overlap
            
            if (ql <= l && r <= qr) cnt[node] += val; // Full coverage
            else {
                // Partial coverage - recurse on children
                int m = (l + r) / 2;
                update(node*2, l, m, ql, qr, val);
                update(node*2+1, m, r, ql, qr, val);
            }

            // Update segment length based on coverage count
            if (cnt[node] > 0) seg[node] = xs[r] - xs[l];
            else if (r - l == 1) seg[node] = 0;
            else seg[node] = seg[node*2] + seg[node*2+1];
        }

        // Find y-coordinate that splits total area in half
        public double separateSquares(int[][] squares) {
            // Collect and sort unique x-coordinates
            ArrayList<Double> list = new ArrayList<>();
            
            for (int[] s : squares) {
                list.add((double)s[0]);
                list.add(s[0] + s[2] * 1.0);
            }
            
            xs = list.stream().distinct().sorted().mapToDouble(d -> d).toArray();

            // Create events for square top and bottom edges
            ArrayList<Event> events = new ArrayList<>();
            
            for (int[] s : squares) {
                events.add(new Event(s[1], s[0], s[0]+s[2], 1));
                events.add(new Event(s[1]+s[2], s[0], s[0]+s[2], -1));
            }
            
            events.sort((a,b) -> Double.compare(a.y, b.y));

            // Initialize segment tree
            int n = xs.length;
            cnt = new int[4*n];
            seg = new double[4*n];

            // Process events and calculate total area with horizontal strips
            double total = 0, prevY = events.get(0).y;
            ArrayList<double[]> strips = new ArrayList<>();

            for (Event e : events) {
                if (e.y > prevY) {
                    double h = e.y - prevY;
                    double w = seg[1]; // Get covered width from segment tree root
                    total += w * h;
                    strips.add(new double[]{prevY, h, w});
                    prevY = e.y;
                }

                int l = Arrays.binarySearch(xs, e.x1);
                int r = Arrays.binarySearch(xs, e.x2);
                update(1, 0, n-1, l, r, e.type);
            }

            // Find y-coordinate at half total area
            double half = total / 2, acc = 0;
            for (double[] s : strips) {
                if (acc + s[1]*s[2] >= half) return s[0] + (half - acc) / s[2];
                acc += s[1] * s[2];
            }
            
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] squares = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                squares[i][j] = scanner.nextInt();
            }
        }

        Solution solution = new Jan14SeparateSquares2().new Solution();
        
        System.out.println(solution.separateSquares(squares));

        scanner.close();
    }
}
