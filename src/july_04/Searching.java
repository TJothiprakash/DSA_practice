package july_04;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Searching {

    int binarySearch(@NotNull int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;

            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;

            }


        }


        return -1;
    }

    public static void main(String[] args) {
        int[] test = {21, 432, 3, 43, 65, 23, 75, 86, 8, 34, 75, 86, 23, 75, 86, 34, 76, 2, 7, 5, 8, 4, 3, 79, 7, 79, 458, 6, 683, 57, 45, 776, 564, 75, 63, 4, 5252323, 53235};
        Arrays.sort(test);
        for (int i : test) {
            System.out.print(i + " ");

        }
        System.out.println();
        System.out.println(test[11] + " from the test array");
        int ans = new Searching().binarySearch(test, 21);

        System.out.println(ans);
    }

}
