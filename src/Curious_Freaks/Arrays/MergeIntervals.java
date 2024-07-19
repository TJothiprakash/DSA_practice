package Curious_Freaks.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = new Solution08().merge(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

class Solution08 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals based on the start times

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Non-overlapping intervals, add the merged interval to the result
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Add the last merged interval to the result
        result.add(currentInterval);

        return result.toArray(new int[result.size()][]);
    }
}