package july_04;

import java.util.Arrays;

public class RecursiveBinarysearch {

    int searchBinray(int[] arr, int low, int high, int target) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return searchBinray(arr, mid + 1, high, target);
        } else {
            return searchBinray(arr, low, mid - 1, target);
        }

    }

    public static void main(String[] args) {

        int[] test = {21, 432, 3, 43, 65, 23, 75, 86, 8, 34, 75, 86, 23, 75, 86, 34, 76, 2, 7, 5, 8, 4, 3, 79, 7, 79, 458, 6, 683, 57, 45, 776, 564, 75, 63, 4, 5252323, 53235};
        Arrays.sort(test);
        int arr[]= {0,7,6};
        System.out.println(arr.length+" length is" +
                "");
        for (int i : test) {
            System.out.print(i + " ");

        }
        int low=0,high= test.length-1,target=test[1];
        RecursiveBinarysearch recursiveBinarysearch= new RecursiveBinarysearch();
      int result  =recursiveBinarysearch.searchBinray(test,low,high,target);
        System.out.println();
        System.out.println(result+" hi");
    }

}
