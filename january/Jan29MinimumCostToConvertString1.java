package january;

import java.util.Arrays;

public class Jan29MinimumCostToConvertString1 {
    class Solution {
        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
            // Initialize INF to a large value (avoiding overflow in addition)
            int INF = Integer.MAX_VALUE / 2;
            // dist[i][j] represents minimum cost to convert character i to character j
            int[][] dist = new int[26][26];

            // Initialize distance matrix: all distances to INF except diagonal (same char = 0 cost)
            for (int i = 0; i < 26; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }

            // Build the graph with given character conversions and their costs
            for (int i = 0; i < original.length; i++) {
                int u = original[i] - 'a';
                int v = changed[i] - 'a';
                // Keep the minimum cost if multiple conversions exist for same pair
                dist[u][v] = Math.min(dist[u][v], cost[i]);
            }

            // Floyd-Warshall algorithm to find shortest paths between all character pairs
            for (int k = 0; k < 26; k++) {
                for (int i = 0; i < 26; i++) {
                    for (int j = 0; j < 26; j++) {
                        if (dist[i][k] < INF && dist[k][j] < INF) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }

            // Calculate total cost to convert source string to target string
            long total_cost = 0;
            for (int i = 0; i < source.length(); i++) {
                int s = source.charAt(i) - 'a';
                int t = target.charAt(i) - 'a';
                // Skip if characters are already the same
                if (s == t) continue;
                // Return -1 if conversion is impossible
                if (dist[s][t] == INF) return -1;
                total_cost += dist[s][t];
            }

            return total_cost;
        }
    }

    // Driver code - This should not be submitted to leetcode
    public static void main(String[] args) {
        Solution sol = new Jan29MinimumCostToConvertString1().new Solution();
        String source = "abc";
        String target = "bcd";
        char[] original = {'a', 'b', 'c'};
        char[] changed = {'b', 'c', 'd'};
        int[] cost = {1, 1, 1};
        long result = sol.minimumCost(source, target, original, changed, cost);
        System.out.println(result); // Expected output: 3
    }
}
