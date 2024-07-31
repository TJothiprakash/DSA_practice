package Curious_Freaks.stringHard;

class Solution04 {
    int[] lps(String s) {
        int m = s.length();
        int[] lps = new int[m];
        int length = 0; // length of the previous longest prefix suffix
        int i = 1; // index for the current character in the string

        lps[0] = 0; // lps[0] is always 0

        while (i < m) {
            if (s.charAt(i) == s.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                // mismatch after length matches
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}

public class LPS {
}
