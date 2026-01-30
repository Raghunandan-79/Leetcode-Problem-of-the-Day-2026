package january;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Jan30MinimumCostToConvertString2 {
    class Solution {
        public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
            // Create a mapping of unique strings to indices
            HashMap<String, Integer> index = new HashMap<>();
            
            for (String o : original) {
                if (!index.containsKey(o)) {
                    index.put(o, index.size());
                }
            }
            
            for (String c : changed) {
                if (!index.containsKey(c)) {
                    index.put(c, index.size());
                }
            }
            
            // Initialize distance matrix using Floyd-Warshall algorithm
            long[][] dis = new long[index.size()][index.size()];
            
            for (int i = 0; i < dis.length; i++) {
                Arrays.fill(dis[i], Long.MAX_VALUE);
                dis[i][i] = 0;
            }
            
            // Fill in direct conversion costs
            for (int i = 0; i < cost.length; i++) {
                dis[index.get(original[i])][index.get(changed[i])] = Math.min(dis[index.get(original[i])][index.get(changed[i])], (long)cost[i]);
            }

            // Floyd-Warshall: find shortest paths between all pairs
            for (int k = 0; k < dis.length; k++) {
                for (int i = 0; i < dis.length; i++) {
                    if (dis[i][k] < Long.MAX_VALUE) {
                        for (int j = 0; j < dis.length; j++) {
                            if (dis[k][j] < Long.MAX_VALUE) {
                                dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                            }
                        }
                    }
                }
            }

            // Collect all possible substring lengths from original strings
            HashSet<Integer> set = new HashSet<>();
            for (String o : original) {
                set.add(o.length());
            }

            // DP array where dp[i] represents minimum cost to transform source[0..i-1] to target[0..i-1]
            long[] dp = new long[target.length() + 1];
            Arrays.fill(dp, Long.MAX_VALUE);
            dp[0] = 0L;
            
            // Process each position in target string
            for (int i = 0; i < target.length(); i++) {
                if (dp[i] == Long.MAX_VALUE) {
                    continue;
                }
                
                // If characters match, no conversion needed
                if (target.charAt(i) == source.charAt(i)) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[i]);
                }
                
                // Try all possible substring lengths
                for (int t : set) {
                    if (i + t >= dp.length) {
                        continue;
                    }
                    
                    // Get indices of source and target substrings
                    int c1 = index.getOrDefault(source.substring(i, i + t), -1);
                    int c2 = index.getOrDefault(target.substring(i, i + t), -1);
                    
                    // If conversion is possible, update DP
                    if (c1 >= 0 && c2 >= 0 && dis[c1][c2] < Long.MAX_VALUE) {
                        dp[i + t] = Math.min(dp[i + t], dp[i] + dis[c1][c2]);
                    }
                }
            }
            
            return dp[dp.length - 1] == Long.MAX_VALUE ? -1L : dp[dp.length - 1];
        }
    }

    // Driver code - This should not be submitted to leetcode
    public static void main(String[] args) {
        Solution solution = new Jan30MinimumCostToConvertString2().new Solution();
        String source = "abcd";
        String target = "acbe";
        String[] original = {"a", "b", "c", "c", "e", "d"};
        String[] changed = {"b", "c", "b", "e", "b", "e"};
        int[] cost = {2, 5, 5, 1, 2, 20};
        System.out.println(solution.minimumCost(source, target, original, changed, cost));
    }
}
