package july_15;

class ChampagneTower {

    public static void main(String[] args) {
        ChampagneTower tower = new ChampagneTower();
        System.out.println(tower.champagneTower(4, 2, 0)); // Output example
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        return dp(poured, query_row, query_glass);
    }

    private double dp(int poured, int r, int c) {
        if (r < 0 || c < 0 || c > r) return 0.0;
        if (r == 0 && c == 0) return poured;

        double overflow = (dp(poured, r - 1, c - 1) - 1.0) / 2.0;
        overflow += (dp(poured, r - 1, c) - 1.0) / 2.0;

        return Math.max(0.0, overflow);
    }
}
