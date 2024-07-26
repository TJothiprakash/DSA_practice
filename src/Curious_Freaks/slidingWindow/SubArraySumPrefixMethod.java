package Curious_Freaks.slidingWindow;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class SubArraySumPrefixMethod {
    public static void main(String[] args) {
        int[] test = {1, 2, -3, 4, 5, 6, 7, 8, 9, 10};
        int ans = new SubArraySumPrefixMethod().maxLen(test, 10);
        System.out.println(ans);
    }

    int maxLen(int @NotNull [] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Your code here
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                max = i + 1;
            } else {
                if (map.get(sum) != null) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return max;
    }
}
