package Curious_Freaks.BinarySearch;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        //int ans = searchInSorted(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, 100);
        // System.out.println(ans);
        int floor = findFloor(new long[]{1, 2, 3, 4, 5, 7, 8, 9, 10}, 10, 6);
        System.out.println(floor);
    }

    static int searchInSorted(int[] arr, int N, int K) {

        // Your code here
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == K) {
                return 1;
            } else if (arr[mid] < K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }

    static int findFloor(long[] arr, int n, long x) {

        // Your code here
        int ans = -1;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    ArrayList<Integer> find(int[] arr, int n, int x) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                ans.add(mid);
                ans.add(mid - 1);
                break;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;

    }
}
