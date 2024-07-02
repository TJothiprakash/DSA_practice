import org.jetbrains.annotations.NotNull;

class PrefixSum {
    public int maxSubarraySum(int @NotNull [] nums, int k) {
        // Calculate prefix sums
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int maxSum = Integer.MIN_VALUE;

        // Iterate through the array to find the maximum sum of a subarea of length k
        for (int i = k; i <= nums.length; i++) {
            int currentSum = prefixSum[i] - prefixSum[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        PrefixSum prefixSum = new PrefixSum();
        int arr[] = {1, 4, 2, 5, 66, 112, 43};
        int ans = prefixSum.maxSubarraySum(arr, 3);
        System.out.println(ans);
    }
}
