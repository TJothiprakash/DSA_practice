package test;

public class test0 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 9, 8};
        int[] res = rotateArray(arr, 2);
        for (int r : res) {
            System.out.print(r + " ");

        }
    }

    private static int[] rotateArray(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n];

        // Calculate effective rotations (handle cases where k > n)
        k = k % n;

        // Copy elements from k to n-1 into result
        System.arraycopy(arr, k, result, 0, n - k);


        // Copy elements from 0 to k-1 into result
        System.arraycopy(arr, 0, result, n - k, k);

        return result;
    }

}
