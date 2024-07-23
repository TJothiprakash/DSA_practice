package Curious_Freaks.Recursion;

public class RecursiveAtoi {
}

class Solution04 {

    public static void main(String[] args) {
        Solution04 sol = new Solution04();
        System.out.println(sol.atoi("-123")); // Output: -123
        System.out.println(sol.atoi("21a"));  // Output: -1
        System.out.println(sol.atoi("123"));  // Output: 123
        System.out.println(sol.atoi("0"));    // Output: 0
        System.out.println(sol.atoi("-"));    // Output: -1
    }

    // Helper recursive function to perform conversion
    private int atoiRecursive(String s, int index, int result, int sign) {
        // Base case: if index reaches the length of the string, return the result
        if (index == s.length()) {
            return result * sign;
        }

        // Check if the current character is a digit
        char c = s.charAt(index);
        if (c < '0' || c > '9') {
            return -1; // If not a digit, return -1
        }

        // Update the result
        result = result * 10 + (c - '0');

        // Recursive call to process the next character
        return atoiRecursive(s, index + 1, result, sign);
    }

    public int atoi(String s) {
        // Edge case: Check if the string is null or empty
        if (s == null || s.isEmpty()) {
            return -1;
        }

        int sign = 1;  // To handle negative numbers
        int start = 0; // Index to start converting digits

        // Check if the first character is a negative sign
        if (s.charAt(0) == '-') {
            sign = -1;
            start = 1;
            // Edge case: A single '-' is not a valid number
            if (s.length() == 1) {
                return -1;
            }
        }

        // Call the helper recursive function
        return atoiRecursive(s, start, 0, sign);
    }
}
