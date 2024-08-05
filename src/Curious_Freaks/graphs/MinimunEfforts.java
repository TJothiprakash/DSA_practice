package Curious_Freaks.graphs;

class Tuple {
    int distance;
    int row;
    int col;

    public Tuple(int distance, int row, int col) {
        this.row = row;
        this.distance = distance;
        this.col = col;
    }
}

class tuf1 {

    public static void main(String[] args) {

        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        MinimumEfforts obj = new MinimumEfforts();
        int ans = obj.MinimumEffort(heights);

        System.out.print(ans);
        System.out.println();
    }
}
