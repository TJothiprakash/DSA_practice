package july_08;
import java.util.*;
public class SubsetSumEqualstoTarget {
    public static void main(String[] args) {
        int arr[]= {1,7,9,0};
        int target= 18;
        SubsetSumEqualstoTarget subsetSumEqualstoTarget= new SubsetSumEqualstoTarget();
        System.out.println(subsetSumEqualstoTarget.check(arr.length-1,target,arr));
    }

    boolean check(int index, int target, int[] arr) {


        if (target == 0) return true;
        if (index == 0) return arr[0]==target;

        boolean not_take = check(index - 1, target, arr);


        boolean take = false;
        if (target >= arr[index]) {
            take = check(index - 1, target - arr[index], arr);
        }


        return take || not_take;

    }

}




class TUF {
    // Helper function to solve subset sum problem using dynamic programming
    static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        // If the target sum is achieved, return true
        if (target == 0)
            return true;

        // If we have considered all elements but haven't reached the target, return false
        if (ind == 0)
            return arr[0] == target;

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        // Try not taking the current element
        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        // Try taking the current element if it doesn't exceed the target
        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);

        // Store the result in the DP table and return whether either option was successful
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    // Main function to check if there exists a subset with a given target sum
    static boolean subsetSumToK(int n, int k, int[] arr) {
        // Create a DP table with dimensions [n][k+1]
        int dp[][] = new int[n][k + 1];

        // Initialize DP table with -1 (unprocessed)
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return subsetSumUtil(n - 1, k, arr, dp);
    }

    public static void main(String args[]) {
        int arr[] = { 12,16,30,21 };
        int k = 4;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToK(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}