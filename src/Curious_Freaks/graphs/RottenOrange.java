package Curious_Freaks.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {

    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int rotting = rottenoranges(arr);
        System.out.println("Minimum Number of Minutes Required " + rotting);
    }

    private static int rottenoranges(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int column = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int totalfruits = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] != -1) {
                    totalfruits++;
                }
            }
        }
        if (totalfruits == 0) return 0;
        int countminutes = 0, cnt = 0;
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};


        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt += size;
            for (int i = 0; i < size; i++) {
                int[] currentPoint = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = currentPoint[0] + x[j];
                    int ny = currentPoint[1] + y[j];
                    if (nx < 0 || ny < 0 || nx >= row || ny >= column || grid[nx][ny] == 0 || grid[nx][ny] == 2)
                        continue;
                    grid[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
            if (queue.size() != 1) countminutes++;
        }
        return totalfruits == cnt ? countminutes : -1;
    }

}
/*


class TUF {
    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] != 0) {
                    count_fresh++;
                }
            }
        }

        if (count_fresh == 0) return 0;
        int countMin = 0, cnt = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        //bfs starting from initially rotten oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt += size;
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 ||
                            grid[x][y] == 2) continue;

                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }
            if (queue.size() != 0) {
                countMin++;
            }
        }
        return count_fresh == cnt ? countMin : -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required " + rotting);
    }
}*/
