package Curious_Freaks.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumk {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = arr.length;
        int s = 18;
        ArrayList<Integer> list = subarraySum(arr, n, s);
        System.out.println(list);
    }

    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> list = new ArrayList<>();

        int start = 0, end = 0, sum = 0;

        while (end < n) {
            sum += arr[end];

            // Shrink the window from the left if sum exceeds s
            while (sum > s && start < end) {
                sum -= arr[start];
                start++;
            }

            // Check if sum equals s
            if (sum == s) {
                list.add(start); // Converting to 1-based index
                list.add(end);   // Converting to 1-based index
                return list;
            }

            end++;
        }

        // If no subarray found
        list.add(-1);
        return list;
    }
}


class tUf {
    public static int findAllSubarraysWithGivenSum(int[] arr, int k) {
        int n = arr.length; // size of the given array.
        Map mpp = new HashMap();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            cnt += (int) mpp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, (int) mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        int cnt = findAllSubarraysWithGivenSum(arr, k);
        System.out.println("The number of subarrays is: " + cnt);
    }
}

