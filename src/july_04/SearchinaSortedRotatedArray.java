package july_04;

import org.jetbrains.annotations.NotNull;

public class SearchinaSortedRotatedArray {
    public static void main(String[] args) {
    int arr[]={8,9,10,1,2,3,4,5,6,7};
    SearchinaSortedRotatedArray searchinaSortedRotatedArray= new SearchinaSortedRotatedArray();
    int ans=searchinaSortedRotatedArray.search(arr,6);
        System.out.println(ans);
    }

    int search(int @NotNull [] arr, int target) {
        int low = 0, high = arr.length - 1, n = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            if (arr[low] <= arr[mid]) {
                if (target <= arr[mid] && target <= arr[low]) {
                    high = mid - 1;

                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target < arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }


        }


        return -1;
    }
}
