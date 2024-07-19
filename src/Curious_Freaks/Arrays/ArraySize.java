package Curious_Freaks.Arrays;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

public class ArraySize {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = {1, 2, 3, 4, 5, 8};
        int[] arr2 = {1, 2, 3, 4, 5, 0};
        //System.out.println(Solution.check(arr1, arr2));

        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        // System.out.println(Solution.rotateArray(arr, 2));
        for (int m : arr) {
            // System.out.print(m + " ");
        }
        System.out.println();
        int[] test = {0, 1, 4, 2, 5, 2, 6, 0, 463, 6, 76, 4, 0, 523, 0, 0, 43, 7, 8, 9, 0};
        Solution s = new Solution();
        s.moveZerosToEnd(test);
    }
}

class Solution {
    // Function to check if two arrays are equal or not.
    @Contract(pure = true)
    public static boolean check(int[] arr1, int[] arr2) {
        // Your code here\
        boolean status = false;
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return status;
                }
            }
            status = true;
        }
        return status;


    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        // Write your code here.
        int[] test = new int[arr.size()];
        int j = 0;
        for (int i : arr) {

            test[j] = i;
            j++;

        }

        reverse(test, 0, k - 1);
        reverse(test, k, test.length - 1);
        reverse(test, 0, test.length - 1);
        arr.clear();
        for (int i = 0; i < test.length; i++) {
            arr.add(test[i]);
        }
        return arr;
    }

    static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] arr) {
        int temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;

    }

    public void moveZerosToEnd(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        for (int k = j; k < arr.length; k++) {
            if (arr[k] != 0) {
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j++;
            }

        }
        for (int l : arr) {
            System.out.print(l + " ");
        }
    }
}