package march;

import java.util.ArrayList;

public class Mar15FancySequence {
    class Fancy {
        private static final int MOD = 1000000007; // Modulo for all operations
        private ArrayList<Long> val;  // Stores normalized values
        private long a, b;   // a: cumulative multiplier, b: cumulative adder

        public Fancy() {
            val = new ArrayList<>(); 
            a = 1; // Initial multiplier
            b = 0; // Initial adder
        }

        // Fast modular exponentiation for inverse calculation
        private long modPow(long x, long y, long mod) {
            long res = 1;
            x = x % mod;
            while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % mod;
            }
            y = y / 2;
            x = (x * x) % mod;
            }
            return res;
        }

        // Append a value after normalizing it with current a and b
        public void append(int val) {
            long x = (val - b + MOD) % MOD;
            this.val.add((x * modPow(a, MOD - 2, MOD)) % MOD);  // Store normalized value
        }

        // Add inc to all elements (update cumulative adder)
        public void addAll(int inc) {
            b = (b + inc) % MOD;
        }

        // Multiply all elements by m (update cumulative multiplier and adder)
        public void multAll(int m) {
            a = (a * m) % MOD;
            b = (b * m) % MOD;
        }

        // Get the value at idx after applying all operations
        public int getIndex(int idx) {
            if (idx >= val.size()) return -1; 
            return (int)((a * val.get(idx) + b) % MOD);
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Fancy fancy = new Mar15FancySequence().new Fancy();
        fancy.append(2);   // Sequence: [2]
        fancy.addAll(3);   // Sequence: [5]
        fancy.append(7);   // Sequence: [5, 7]
        fancy.multAll(2);  // Sequence: [10, 14]
        System.out.println(fancy.getIndex(0)); // Output: 10
        fancy.addAll(3);   // Sequence: [13, 17]
        fancy.append(10);  // Sequence: [13, 17, 10]
        fancy.multAll(2);  // Sequence: [26, 34, 20]
        System.out.println(fancy.getIndex(0)); // Output: 26
        System.out.println(fancy.getIndex(1)); // Output: 34
        System.out.println(fancy.getIndex(2)); // Output: 20
    }
}
