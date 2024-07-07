package july_7;

public class SearchinSortedArray {
    public static void main(String[] args) {
        int[] rotatedarr = {3, 4, 5,5,5, 6, 7, 8, 9, 1, 2};
        SearchinSortedArray searchinSortedArray = new SearchinSortedArray();
        System.out.println(searchinSortedArray.search(rotatedarr, 5));
    }

    int search(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;


            if (arr[mid] == target) return mid;
            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left = left + 1;
                right = right - 1;
                continue;
            }
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] <= target && target <= arr[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
