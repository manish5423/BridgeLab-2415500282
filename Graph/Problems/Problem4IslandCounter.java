import java.util.*;

public class Problem4IslandCounter {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final int[][] DIAGONAL_DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int countIslandsDFS(int[][] grid) {
        return countIslandsDFS(grid, false);
    }

    public int countIslandsDFS(int[][] grid, boolean diagonal) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    count++;
                    dfs(grid, visited, row, col, diagonal);
                }
            }
        }
        return count;
    }

    public int countIslandsBFS(int[][] grid) {
        return countIslandsBFS(grid, false);
    }

    public int countIslandsBFS(int[][] grid, boolean diagonal) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    count++;
                    bfs(grid, visited, row, col, diagonal);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, boolean[][] visited, int row, int col, boolean diagonal) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int[] direction : directions(diagonal)) {
            dfs(grid, visited, row + direction[0], col + direction[1], diagonal);
        }
    }

    private void bfs(int[][] grid, boolean[][] visited, int row, int col, boolean diagonal) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] direction : directions(diagonal)) {
                int nextRow = cell[0] + direction[0];
                int nextCol = cell[1] + direction[1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid[0].length && grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }

    private int[][] directions(boolean diagonal) {
        return diagonal ? DIAGONAL_DIRECTIONS : DIRECTIONS;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 1}
        };
        Problem4IslandCounter counter = new Problem4IslandCounter();
        System.out.println(counter.countIslandsDFS(grid));
        System.out.println(counter.countIslandsBFS(grid));
        System.out.println(counter.countIslandsDFS(grid, true));
    }
}