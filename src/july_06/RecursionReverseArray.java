package july_06;

public class RecursionReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        RecursionReverseArray recursionRotateArray = new RecursionReverseArray();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        recursionRotateArray.rotateArray(0, arr.length - 1, arr);

        System.out.println();
        // recursionRotateArray.rotateArray(0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    void rotateArray(int left, int right, int[] arr) {
        if (left >= right) {
            return;
        }
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        rotateArray(left + 1, right - 1, arr);

    }

}
