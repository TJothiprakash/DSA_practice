package july_10;

import org.jetbrains.annotations.NotNull;

public class InterLeaving {
    public static void main(String[] args) {
        Solution8 sol = new Solution8();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(sol.isInterleave(s1, s2, s3));
    }

}

class Solution8 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false; // quick check
        return checkinterleaving(s1, s2, s3, 0, 0, 0);
    }

    private boolean checkinterleaving(String s1, String s2, @NotNull String s3, int i, int j, int k) {
        // Base case: if all strings are fully traversed
        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }

        // Check if the current character of s3 matches the current character of s1
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (checkinterleaving(s1, s2, s3, i + 1, j, k + 1)) {
                return true;
            }
        }

        // Check if the current character of s3 matches the current character of s2
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            return checkinterleaving(s1, s2, s3, i, j + 1, k + 1);
        }

        return false; // If neither condition is satisfied, return false
    }
}
