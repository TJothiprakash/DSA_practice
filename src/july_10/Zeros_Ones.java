package july_10;


/*You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.



Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
Example 2:

Input: strs = ["10","0","1"], m = 1, n = 1
Output: 2
Explanation: The largest subset is {"0", "1"}, so the answer is 2.


Constraints:

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] consists only of digits '0' and '1'.
1 <= m, n <= 100
*/

/*
 * i express everything in terms of index
 * ii explore all possibilities
 * iii return the max/min*/
public class Zeros_Ones {
    public static void main(String[] args) {
        Zeros_Ones zerosOnes = new Zeros_Ones();
        String[] arr = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(arr, 0, 5, 3));
    }

    public static int findMaxForm(String[] strs, int index, int m, int n) {

        if (index >= strs.length) return 0;

        if (m == 0 && n == 0) return 0;
        String temp = strs[index];
        int count = 0, countones = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '0') {
                count++;
            } else {
                countones++;
            }
        }
        int include = 0;
        if (count <= m && countones <= n) {
            include = 1 + findMaxForm(strs, index + 1, m - count, n - countones);
        }
        int exclude = findMaxForm(strs, index + 1, m, n);
        return Math.max(include, exclude);

    }
}
