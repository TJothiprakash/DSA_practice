package Cuious_Freaks.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 2, 2, 2, 2, 1, 5, 6, 3, 5, 3};
        int n = arr.length;
        int ans = findMajority(arr, n);
        System.out.println(ans);
    }

    private static int findMajority(int[] arr, int n) {

        int count = 0;
        int maxcount = 0;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {

            if (count == 0) {
                num = arr[i];
            }

            if (arr[i] == num) count++;
            else count--;

            if (count > maxcount) {
                maxcount = count;
                num = arr[i];
            }
        }

        return num;

    }
}



