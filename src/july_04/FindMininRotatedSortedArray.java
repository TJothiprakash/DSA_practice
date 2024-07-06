package july_04;

public class FindMininRotatedSortedArray {
    public static void main(String[] args) {
        FindMininRotatedSortedArray firstAndLastOccurrance = new FindMininRotatedSortedArray();
        int[] arr = {4, 5, 6, 7, 8, 9,10, 1, 2, 3};
        int ans = firstAndLastOccurrance.searchMin(arr);
        System.out.println(ans);
    }

    int searchMin(int[] arr) {
        int ans = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1, n = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[mid]);
                low = mid + 1;

            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }

        }
        return ans;
    }

}
