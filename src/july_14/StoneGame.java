package july_14;

import java.util.Arrays;

public class StoneGame {

    private int[][] memo;
    private int[] suffixSum;

    public static void main(String[] args) {
        int[] piles = {2, 7, 9, 4, 4};
        StoneGame stoneGame = new StoneGame();
        System.out.println(stoneGame.stoneGameII(piles));
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        return dp(0, 1);
    }

    private int dp(int i, int m) {
        if (i == suffixSum.length) {
            return 0;
        }
        if (2 * m >= suffixSum.length - i) {
            return suffixSum[i];
        }
        if (memo[i][m] != -1) {
            return memo[i][m];
        }
        int minOpponentStones = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; x++) {
            minOpponentStones = Math.min(minOpponentStones, dp(i + x, Math.max(m, x)));
        }
        memo[i][m] = suffixSum[i] - minOpponentStones;
        return memo[i][m];
    }
}
