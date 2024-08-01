package Curious_Freaks.dynamic_programming;

public class TrickyQn {
}
/*There are N stairs, and a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does not matter).
Note:
Order does not matter means for N = 4 {1 2 1},{2 1 1},{1 1 2} are considered same.

Example 1:

Input: N = 4
Output: 3
Explanation: Three ways to reach at 4th stair.
They are {1, 1, 1, 1}, {1, 1, 2}, {2, 2}.
Example 2:

Input: N = 5
Output: 3
Explanation: Three ways to reach at 5th stair.
They are {1, 1, 1, 1, 1}, {1, 1, 2, 1} and {1, 2, 2}.
Your Task:
You don't need to read or print anyhting. Your task is to complete the function nthStair() which takes an integer N as input parameter and returns the total number of ways to reach at Nth stair.

Expected Time Complexity: O(1)
Expected Space Complexity: O(1)

Constraints:
1 ≤ N ≤ 104

*/

class Solution04 {
    // Function to count number of ways to reach the nth stair
    public long nthStair(int n) {
        // The number of distinct ways is the same as the number of combinations of 2-steps and 1-steps
        // which can be computed using combinatorial logic.

        // Calculate the number of distinct combinations
        return countDistinctWays(n);
    }

    // Helper method to count distinct ways
    private long countDistinctWays(int n) {
        // The number of distinct ways to reach the nth stair is given by the number of combinations
        // of 2-steps and 1-steps that sum up to n.

        // Calculate the maximum number of 2-steps
        int maxTwoSteps = n / 2;

        // The number of distinct ways is simply the count of possible numbers of 2-steps
        return maxTwoSteps + 1; // Include the case of using only 1-steps
    }
}
