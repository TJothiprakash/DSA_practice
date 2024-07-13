package july_11;

public class RotateFunction {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        int[] arr = {4, 3, 2, 6};
        System.out.println(solution10.maxRotateFunction(arr));
        
    }
}

class Solution10 {/*
    public int maxRotateFunction(int[] nums) {
        int ans = 0, len = nums.length, index = 1;
        return generatePossibilities(nums, index, len, ans);

    }

    private int generatePossibilities(int[] nums, int index, int len, int maxSum) {
        if (index >= nums.length) return maxSum;

        int[] res = rotateArray(nums, index);
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i] * (i + 1);
        }
        return generatePossibilities(nums, index + 1, len, Math.max(sum, maxSum));
    }


    private int[] rotateArray(int[] nums, int index) {
        int n = nums.length;
        int[] result = new int[n];

        // Calculate effective rotations (handle cases where k > n)
        index = index % n;

        // Copy elements from k to n-1 into result
        System.arraycopy(nums, index, result, 0, n - index);


        // Copy elements from 0 to k-1 into result
        System.arraycopy(nums, 0, result, n - index, index);

        return result;
    }*/

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0, currentValue = 0;

        // Initial sum and F(0) calculation
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            currentValue += i * nums[i];
        }

        int maxValue = currentValue;

        // Iteratively calculate F(k) for k from 1 to n-1
        for (int k = 1; k < n; k++) {
            currentValue = currentValue + sum - n * nums[n - k];
            maxValue = Math.max(maxValue, currentValue);
        }

        return maxValue;
    }
}

