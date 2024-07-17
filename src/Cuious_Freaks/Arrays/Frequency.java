package Cuious_Freaks.Arrays;

public class Frequency {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int N = arr.length;
        int P = 2;
        frequencyCount(arr, N, P);
        for (int i = 0; i < N; i++) {
            //  System.out.print(arr[i] + " ");
        }
    }

    public static void frequencyCount(int[] arr, int N, int P) {
        // Ensure all elements are within the range 1 to N
        for (int i = 0; i < N; i++) {
            if (arr[i] > N) {
                arr[i] = 0;
            }
        }

        // Use the array to count frequencies
        for (int i = 0; i < N; i++) {
            if (arr[i] % (N + 1) > 0) {
                arr[(arr[i] % (N + 1)) - 1] += (N + 1);
            }
        }

        // Extract the frequencies
        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] / (N + 1);
        }
    }
}


class tuf {

    public static void main(String[] args) {

        int[] arr = {10, 5, 10, 15, 10, 5};
        int n = arr.length;
        countFreq(arr, n);
    }

    public static void countFreq(int[] arr, int n) {
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            // Skip this element if already processed
            if (visited[i])
                continue;

            // Count frequency
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " " + count);
        }
    }
}
