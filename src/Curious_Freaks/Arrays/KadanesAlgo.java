package Curious_Freaks.Arrays;

public class KadanesAlgo {
    public static void main(String[] args) {
        long[] arr = {7, 72, 90, 21, 60};
        int ans2 = (int) inversionCount(arr, arr.length);
        System.out.println(ans2);
        int[] test = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // int ans = getmax(arr);
        int res = getmax(test);
        // System.out.println(res);
        // System.out.println(ans);
    }

    private static int getmax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int ansstart = 0;
        int ansend = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                ansstart = i;
            }
            sum += arr[i];
            if (sum > max) {
                max = sum;
                ansend = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        // System.out.println();
       /* for (int i = ansstart; i <= ansend; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();*/
        return max;
    }


    // Function to count inversions in the array.
    static long inversionCount(long[] arr, int n) {
        // Your Code Here
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }

        }
        return count;
    }

}
