package Curious_Freaks.slidingWindow;


import java.util.ArrayDeque;
import java.util.Deque;

class Compute {
    public static void main(String[] args) {
        long[] A = {12, -1, -7, 8, -15, 30, 16, 28};

        int N = A.length;
        int K = 3;
        long[] result = printFirstNegativeInteger(A, N, K);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static long[] printFirstNegativeInteger(long[] A, int N, int K) {
        // Result array
        long[] result = new long[N - K + 1];
        // Deque to store indices of negative numbers
        Deque<Integer> deque = new ArrayDeque<>();

        // Process the first window of size K
        for (int i = 0; i < K; i++) {
            if (A[i] < 0) {
                deque.addLast(i);
            }
        }

        // Store the result for the first window
        result[0] = deque.isEmpty() ? 0 : A[deque.peekFirst()];

        // Slide the window over the rest of the array
        for (int i = K; i < N; i++) {
            // Remove the element that is going out of the window
            while (!deque.isEmpty() && deque.peekFirst() <= i - K) {
                deque.pollFirst();
            }

            // Add the new element if it is negative
            if (A[i] < 0) {
                deque.addLast(i);
            }

            // Store the result for the current window
            result[i - K + 1] = deque.isEmpty() ? 0 : A[deque.peekFirst()];
        }

        return result;


    }
}

