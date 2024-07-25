package Curious_Freaks.Stack;

public class Celebrity {

    public static void main(String[] args) {

        int[][] M = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
        int n = 3;
        int celebrity = new Celebrity().celebrity(M, n);
        System.out.println(celebrity);
    }

    // Function to find if there is a celebrity in the party or not.
    int celebrity(int[][] M, int n) {
        // Step 1: Find the potential celebrity
        int left = 0, right = n - 1;

        while (left < right) {
            if (M[left][right] == 1) {
                // left knows right, so left cannot be the celebrity
                left++;
            } else {
                // left does not know right, so right cannot be the celebrity
                right--;
            }
        }

        // Step 2: Verify if the found candidate is a celebrity
        int candidate = left;

        for (int i = 0; i < n; i++) {
            if (i != candidate && (M[candidate][i] == 1 || M[i][candidate] == 0)) {
                return -1; // Candidate knows someone or is not known by someone
            }
        }

        return candidate; // Found celebrity
    }
}

