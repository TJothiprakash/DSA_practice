package Curious_Freaks.stringHard;

import java.util.ArrayList;
import java.util.Scanner;

class Solution05 {

    // Function to create the bad character table
    private static int[] createBadCharTable(String pattern) {
        final int ALPHABET_SIZE = 256; // Number of possible characters
        int[] badChar = new int[ALPHABET_SIZE];
        int m = pattern.length();

        // Initialize all occurrences with -1
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            badChar[i] = -1;
        }

        // Fill the bad character table
        for (int i = 0; i < m; i++) {
            badChar[pattern.charAt(i)] = i;
        }

        return badChar;
    }

    // Boyer-Moore algorithm for pattern searching
    public static ArrayList<Integer> patternSearch(String text, String pattern) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        if (m == 0 || n == 0 || m > n) {
            result.add(-1);
            return result;
        }

        int[] badChar = createBadCharTable(pattern);
        int s = 0; // Shift of the pattern with respect to text

        while (s <= (n - m)) {
            int j = m - 1;

            // Check from the end of the pattern
            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
                j--;
            }

            // If the pattern is found
            if (j < 0) {
                result.add(s); // Match found at index s
                s += (s + m < n) ? m - badChar[text.charAt(s + m)] : 1;
            } else {
                s += Math.max(1, j - badChar[text.charAt(s + j)]);
            }
        }

        if (result.isEmpty()) {
            result.add(-1);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline

        for (int t = 0; t < T; t++) {
            String text = sc.nextLine();
            String pattern = sc.nextLine();
            ArrayList<Integer> result = patternSearch(text, pattern);

            for (int index : result) {
                System.out.print(index + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

public class BoyerMoorAlgo {
}
