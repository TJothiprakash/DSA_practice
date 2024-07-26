package Curious_Freaks.slidingWindow;

public class GenerateSubArrays {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 10;
        System.out.println(generateSubArrays(test, target));
    }

    static int generateSubArrays(int[] arr, int target) {

        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == target) {
                    length = Math.max(length, j - i + 1);


                }
            }
        }
        return length;

    }

}
