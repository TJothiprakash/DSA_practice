package july_04;

public class FindminRotatedArraywithDuplicates {


    public static void main(String[] args) {
        FindminRotatedArraywithDuplicates findminRotatedArraywithDuplicates = new FindminRotatedArraywithDuplicates();
        int[] arr = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int ans = findminRotatedArraywithDuplicates.searchMin(arr);

        System.out.println(ans);
    }

    int searchMin(int[] arr) {
        int ans = Integer.MAX_VALUE;
        int index =-1;
        int low = 0, high = arr.length - 1, n = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] <= arr[mid]) {
                index= mid;
               // System.out.println(index +" no of times array is rotated");
                ans = Math.min(ans, arr[mid]);
                low = mid + 1;

            } else {
                ans = Math.min(ans, arr[mid]);
                index=mid;
               // System.out.println(index +" no of times array is rotated");
                high = mid - 1;
            }

        }
        System.out.println(low +" no of times array is rotated");
        return ans;
    }


}
