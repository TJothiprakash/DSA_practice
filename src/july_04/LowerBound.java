package july_04;

public class LowerBound {
    public static void main(String[] args) {
        LowerBound lowerBound = new LowerBound();
        int[] arr = {1, 2, 3, 4, 5, 7, 10};
        int r = lowerBound.lowerbound(arr, 12);
        System.out.println(r);
    }

    private int lowerbound(int[] arr, int target) {
        int ans = arr.length;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
