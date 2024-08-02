package Curious_Freaks.dynamic_programming.subsequence;

import java.util.ArrayList;

public class GenerateSubsequnce {
    public static void main(String[] args) {
        String test = "abc";
        int[] arr = {1, 2, 3, 5};
        int targetsum = 45;
        ArrayList<Integer> list = new ArrayList<>();
        generateSubsequence(arr, 0, "", list, targetsum);
    }


    public static void generateSubsequence(int[] arr, int index, String ans, ArrayList<Integer> list, int targetsum) {
        if (index == arr.length) {
            System.out.println(list);
            return;
        }
        list.add(arr[index]);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        if (sum == targetsum) {
            System.out.println("yes");
        }
        generateSubsequence(arr, index + 1, ans, list, targetsum);
        list.remove(list.size() - 1);
        generateSubsequence(arr, index + 1, ans, list, targetsum);
    }


}
