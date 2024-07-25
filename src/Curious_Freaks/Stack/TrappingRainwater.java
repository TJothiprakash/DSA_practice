package Curious_Freaks.Stack;
// findout the maximum amount of water that can be stored in the array
//compute the prefix max and suffix max array for a given array
// compute the water storage using min(prefix max, suffix max) - array[i]
/// as simple as that in brutforce

public class TrappingRainwater {
}

// optmised solution
class Solution05 {
    public int trap(int[] height) {

        int n = height.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        int maxleft = 0, maxright = 0;

        while (left <= right) {

            if (height[left] <= height[right]) {

                if (height[left] >= maxleft) maxleft = height[left];
                else res += maxleft - height[left];

                left++;
            } else {

                if (height[right] >= maxright) maxright = height[right];
                else res += maxright - height[right];

                right--;
            }
        }
        return res;
    }
}