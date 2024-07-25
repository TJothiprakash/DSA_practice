package Curious_Freaks.slidingWindow;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDigits {
    public static void main(String[] args) {

        int[] A = {1, 2, 1, 3, 4, 2, 3};
        int N = A.length;
        int K = 4;
        ArrayList<Integer> ans = countDistinct(A, N, K);
        System.out.println(ans);
    }

    static @NotNull ArrayList<Integer> countDistinct(int[] A, int N, int K) {


        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Initialize the frequency map with the first window of size K
        for (int i = 0; i < K; i++) {
            frequencyMap.put(A[i], frequencyMap.getOrDefault(A[i], 0) + 1);
        }

        // Add the count of distinct elements for the first window
        result.add(frequencyMap.size());

        // Slide the window over the rest of the array
        for (int i = K; i < N; i++) {
            // Remove the element that is going out of the window
            int elementOut = A[i - K];
            if (frequencyMap.get(elementOut) == 1) {
                frequencyMap.remove(elementOut);
            } else {
                frequencyMap.put(elementOut, frequencyMap.get(elementOut) - 1);
            }

            // Add the new element that is coming into the window
            int elementIn = A[i];
            frequencyMap.put(elementIn, frequencyMap.getOrDefault(elementIn, 0) + 1);

            // Add the count of distinct elements for the current window
            result.add(frequencyMap.size());
        }

        return result;
    }
}


