package Curious_Freaks.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArraySum {
    public static void main(String[] args) {

        int K = 2;
        ArrayList<Integer> Arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int N = Arr.size();
        System.out.println(maximumSumSubarray(K, Arr, N));
    }

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        // code here

        int maxsum = 0, sum = 0;
        for (int i = 0; i < K; i++) {
            maxsum += Arr.get(i);

        }
        for (int j = K; j < N; j++) {
            sum = maxsum + Arr.get(j) - Arr.get(j - K);
            maxsum = Math.max(maxsum, sum);
        }

        return maxsum;
    }
}