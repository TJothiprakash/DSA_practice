package july_13;

import java.util.Stack;

public class Asteroid_Collision {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-4, 4};
        int[] res = solution.asteroidCollision(arr);
        for (int ans : res) {
            System.out.print(ans + " ");

        }
    }
}


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        stack.push(asteroids[0]);
        int i = 1;

        while (i < asteroids.length) {
            int prev = stack.isEmpty() ? 0 : stack.peek();
            int curr = asteroids[i];

            if (curr > 0) {
                stack.push(curr);
                i++;
            } else {
                if (prev > 0) {
                    if (prev == -curr) {
                        stack.pop();
                        i++;
                    } else if (prev > -curr) {
                        i++;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push(curr);
                    i++;
                }
            }
        }

        int[] intArray = new int[stack.size()];

        // Populate the array in reverse order to maintain correct sequence
        for (int j = intArray.length - 1; j >= 0; j--) {
            intArray[j] = stack.pop();
        }

        return intArray;
    }
}


