package february;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Feb17BinaryWatch {
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> result = new ArrayList<>();

            for (int hour = 0; hour < 12; hour++) {

                for (int minute = 0; minute < 60; minute++) {

                    int totalBits = Integer.bitCount(hour) + Integer.bitCount(minute);

                    if (totalBits == turnedOn) {

                        String time = hour + ":" +
                                (minute < 10 ? "0" + minute : minute);

                        result.add(time);
                    }
                }
            }

            return result;
        }
    }

    // Driver code - this should not be submitted to leetcode
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int turnedOn = scanner.nextInt();

        Solution solution = new Feb17BinaryWatch().new Solution();
        for (var num : solution.readBinaryWatch(turnedOn)) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
