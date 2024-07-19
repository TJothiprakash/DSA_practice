package Curious_Freaks.TwoPointer;

public class FindPair {

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int x = 65;
        System.out.println(new FindPair().hasArrayTwoCandidates(test, x));

    }

    //bruteforce approach
   /* boolean hasArrayTwoCandidates(int[] arr, int x) {
        // code here
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == x) {
                    return true;
                }
            }

        }
        return false;
    }*/

    //two pointer approach
    boolean hasArrayTwoCandidates(int[] arr, int x) {
        // code here
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == x) {
                return true;
            } else if (arr[i] + arr[j] > x) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}
