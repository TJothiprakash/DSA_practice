package Curious_Freaks.Recursion;

public class BasicRecursion {
    public static void main(String[] args) {

        Solution basicRecursion = new Solution();
        basicRecursion.printNos(6);
    }
}

class Solution {

    public void printNos(int N) {
        //Your code here
        if (N == 0) return;

        printNos(N - 1);
        System.out.print(N + " ");
    }
}

