package february;

import java.util.HashMap;
import java.util.Scanner;

public class Feb11LongestBalancedSubarray2 {
    class Solution {
        class SegTree {
            int n;
            int[] mint, maxt, lazy;

            public SegTree(int n) {
                this.n = n;
                mint = new int[4 * n];
                maxt = new int[4 * n];
                lazy = new int[4 * n];
            }

            public void push(int node, int st, int end) {
                if (lazy[node] != 0) {
                    mint[node] += lazy[node];
                    maxt[node] += lazy[node];
                    
                    if (st != end) {
                        //not a leaf node has children -> so lazy porpage to children
                        lazy[2 * node + 1] += lazy[node];//left
                        lazy[2 * node + 2] += lazy[node];//right child
                    }
                    
                    lazy[node] = 0;
                }
            }

            public void updateRange(int node, int l, int r, int ql, int qr, int val) {
                push(node, l, r);//lazy
                if (l > qr || r < ql)
                    return;//invalid range
                
                //now if complete overlap
                if (l >= ql && r <= qr) {
                    lazy[node] += val;
                    push(node, l, r);
                    return;
                }
                
                //else some overlap , searcbot left and right childh reursively in  
                int mid = (l + r) / 2;
                updateRange(2 * node + 1, l, mid, ql, qr, val);//left child
                updateRange(2 * node + 2, mid + 1, r, ql, qr, val);//right child
                
                //after recursive fill parent
                mint[node] = Math.min(mint[2 * node + 1], mint[2 * node + 2]);//min of left and right child
                maxt[node] = Math.max(maxt[2 * node + 1], maxt[2 * node + 2]);//max of left and right child
            }

            public int leftmostz(int node, int l, int r) {
                push(node, l, r);//lazy if needed
                
                if (mint[node] > 0 || maxt[node] < 0)
                    return -1;//prune
                
                if (l == r) {
                    //reached leaf check if zero
                    return mint[node] == 0 ? l : -1;
                }
                
                int mid = (l + r) / 2;
                int left = leftmostz(2 * node + 1, l, mid);
                
                if (left != -1)
                    return left;//alrady found in left tree, dont search in right
                
                return leftmostz(2 * node + 2, mid + 1, r);//not found in left , need to search right
            }
        }

        public int longestBalanced(int[] nums) {
            int n = nums.length;
            if (n == 0)
                return 0;

            SegTree seg = new SegTree(n);
            int maxl = 0;//actaul ans to return
            
            HashMap<Integer, Integer> seen = new HashMap<>();//to tackle duplucates
            for (int i = 0; i < n; i++) {
                int val = ((nums[i] & 1) == 0) ? 1 : -1;//even or odd using bit
                if (seen.containsKey(nums[i])) {
                    //must reduce the effect of the duplicate
                    seg.updateRange(0, 0, n - 1, 0, seen.get(nums[i]), -val);
                }
                
                seg.updateRange(0, 0, n - 1, 0, i, val);
                seen.put(nums[i], i);
                int zidx = seg.leftmostz(0, 0, n - 1);
                
                if (zidx != -1 && zidx <= i) {
                    maxl = Math.max(maxl, i - zidx + 1);
                }
            }

            return maxl;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Feb11LongestBalancedSubarray2().new Solution();
        System.out.println(solution.longestBalanced(nums));

        scanner.close();
    }
}
