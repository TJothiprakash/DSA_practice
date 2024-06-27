import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        //int res = main.divisorSubstrings(430043, 2);
        //System.out.println(res);
       // int ans = main.minimumRecolors("WBWBBBW", 7);
        //System.out.println(ans);
        System.out.println(main.minimumDifference(new int[]{9,4,1,7}, 2));
    }

    public int divisorSubstrings(int num, int k) {
        int count = 0;
        int cal = 0;
        String nstr = Integer.toString(num);

        for (int i = 0; i <= nstr.length() - k; i++) {

            cal = Integer.parseInt(nstr.substring(i, i + k));
            if (cal != 0 && num % cal == 0) {
                count++;
            }


        }


        return count;
    }
    /*public int divisorSubstrings(int num, int k) {
    int count = 0;
    String nstr = Integer.toString(num);

    for (int i = 0; i <= nstr.length() - k; i++) {
        int cal = Integer.parseInt(nstr.substring(i, i + k));
        if (cal != 0 && num % cal == 0) {
            count++;
        }
    }

    return count;
}*//*Input: blocks = "WBBWWBBWBW", k = 7
Output: 3
Explanation:
One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
so that blocks = "BBBBBBBWBW".
It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
Therefore, we return 3.
Example 2:

Input: blocks = "WBWBBBW", k = 2
Output: 0
Explanation:
No changes need to be made, since 2 consecutive black blocks already exist.
Therefore, we return 0.*/


    public int minimumRecolors(String blocks, int k) {
        char[] arr = blocks.toCharArray();
        int changes = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] == 'W') changes++;
        }
        int minChanges = changes;
        for (int i = k; i < arr.length; i++) {
            if (arr[i] == 'W') {
                changes++;
            }
            if (arr[i - k] == 'W') {
                changes--;
            }
            minChanges = Math.min(minChanges, changes);
        }
        return minChanges;
    }

    public int minimumDifference(int[] nums, int k) {

        //edge case
        if (k == 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-k;i++){
           min= Math.min(min, nums[i+k-1]-nums[i]);
        }

        return min;
    }


}