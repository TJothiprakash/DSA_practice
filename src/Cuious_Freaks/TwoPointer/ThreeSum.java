package Cuious_Freaks.TwoPointer;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int x = 13;
        System.out.println(find3Numbers(arr, arr.length, x));
    }

    public static boolean find3Numbers(int[] arr, int n, int x) {

        // Your code Here
        int start = arr[0];
        int end = arr[n - 1];
        int third = 0;
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            start = arr[i];
            third = x - start;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (arr[j] + arr[k] == third) {
                    System.out.println(i + " " + j + " " + k);
                    return true;
                } else if (arr[j] + arr[k] < third) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return false;






        /*
// tle occurs here
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == x) {

                        System.out.println(i + " " + j + " " + k);
                        return true;
                    }
                }
            }
        }
        return false;
*/
    }
}
