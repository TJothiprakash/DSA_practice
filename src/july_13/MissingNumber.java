package july_13;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = arr.length;
        MissingNumber mn = new MissingNumber();
        System.out.println(mn.missingNumber(n, arr));
    }

    int missingNumber(int n, int[] arr) {

        int total = (n * (n + 1)) / 2;
        for (int i = 0; i < n - 1; i++) {
            total -= arr[i];
        }
        return total;
    }
}
