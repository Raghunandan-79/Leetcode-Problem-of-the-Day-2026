package march;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mar12MaximizeSpanningTreeStabilityWithUpgrades {
    // Disjoint Set Union (Union-Find) data structure
    class DSU {
        int[] parent;

        // Initialize DSU with given parent array
        DSU(int[] parent) {
            this.parent = parent.clone();
        }

        // Find the root parent of element x with path compression
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // Union two elements by connecting their roots
        void join(int x, int y) {
            int px = find(x);
            int py = find(y);
            parent[px] = py;
        }
    }

    // Solution class for maximizing spanning tree stability
    class Solution {
        private static final int MAX_STABILITY = 200000;

        // Main function to find maximum stability with k edge upgrades allowed
        public int maxStability(int n, int[][] edges, int k) {
            int ans = -1;

            // Check if we have enough edges to form a spanning tree
            if (edges.length < n - 1) {
                return -1;
            }

            // Separate edges into must-include and optional edges
            List<int[]> mustEdges = new ArrayList<>();
            List<int[]> optionalEdges = new ArrayList<>();

            for (int[] edge : edges) {
                if (edge[3] == 1) {
                    mustEdges.add(edge);
                } else {
                    optionalEdges.add(edge);
                }
            }

            // Check if must edges exceed spanning tree limit
            if (mustEdges.size() > n - 1) {
                return -1;
            }

            // Sort optional edges by stability in descending order
            optionalEdges.sort((a, b) -> b[2] - a[2]);

            // Initialize DSU with must edges
            int selectedInit = 0;
            int mustMinStability = MAX_STABILITY;
            int[] initParent = new int[n];

            for (int i = 0; i < n; i++) {
                initParent[i] = i;
            }

            DSU dsuInit = new DSU(initParent);

            // Add all must edges to initial DSU
            for (int[] e : mustEdges) {
                int u = e[0];
                int v = e[1];
                int s = e[2];

                if (dsuInit.find(u) == dsuInit.find(v) || selectedInit == n - 1) {
                    return -1;
                }

                dsuInit.join(u, v);
                selectedInit++;
                mustMinStability = Math.min(mustMinStability, s);
            }

            // Binary search on the minimum stability value
            int l = 0;
            int r = mustMinStability;

            while (l < r) {
                int mid = l + (r - l + 1) / 2;

                // Try to build spanning tree with stability >= mid
                DSU dsu = new DSU(dsuInit.parent);
                int selected = selectedInit;
                int doubledCount = 0;

                for (int[] e : optionalEdges) {
                    int u = e[0];
                    int v = e[1];
                    int s = e[2];

                    // Skip if edge creates a cycle
                    if (dsu.find(u) == dsu.find(v)) {
                        continue;
                    }

                    // Add edge if stability meets threshold or can be doubled
                    if (s >= mid) {
                        dsu.join(u, v);
                        selected++;
                    } else if (doubledCount < k && s * 2 >= mid) {
                        doubledCount++;
                        dsu.join(u, v);
                        selected++;
                    } else {
                        break;
                    }

                    if (selected == n - 1) {
                        break;
                    }
                }

                // Adjust binary search bounds based on whether spanning tree was formed
                if (selected != n - 1) {
                    r = mid - 1;
                } else {
                    ans = l = mid;
                }
            }

            return ans;
        }
    }

    // Driver code - this code should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] edges = new int[m][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                edges[i][j] = scanner.nextInt();
            }
        }

        Solution solution = new Mar12MaximizeSpanningTreeStabilityWithUpgrades().new Solution();
        int result = solution.maxStability(n, edges, k);
        System.out.println(result);

        scanner.close();
    }
}
