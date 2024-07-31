package Curious_Freaks.stringHard;

import java.util.HashMap;

class Solution08 {
    public static void main(String[] args) {
        Solution08 solution = new Solution08();

        // Test cases
        System.out.println(solution.romanToInt("III")); // Output: 3
        System.out.println(solution.romanToInt("IV"));  // Output: 4
        System.out.println(solution.romanToInt("IX"));  // Output: 9
        System.out.println(solution.romanToInt("LVIII")); // Output: 58
        System.out.println(solution.romanToInt("MCMXCIV")); // Output: 1994
    }

    public int romanToInt(String s) {
        // Initialize the HashMap with Roman numeral values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        // Variable to store the result
        int result = 0;

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            // Get the value of the current Roman numeral
            int currentValue = romanMap.get(s.charAt(i));

            // If the next numeral exists and is greater than the current, subtract current value
            if (i < s.length() - 1 && currentValue < romanMap.get(s.charAt(i + 1))) {
                result -= currentValue;
            } else {
                // Otherwise, add the current value
                result += currentValue;
            }
        }

        return result;
    }
}

public class RomanToNumerals {
}
