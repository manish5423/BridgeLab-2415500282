public class RatInAMaze {
    private static final int[][] DIRECTIONS = {
            {1, 0},   // Down
            {0, 1},   // Right
            {-1, 0},  // Up
            {0, -1}   // Left
    };

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] path = new int[maze.length][maze[0].length];

        if (solveMaze(maze, 0, 0, visited, path)) {
            System.out.println("Path found:");
            printPath(path);
        } else {
            System.out.println("No path exists.");
        }
    }

    public static boolean solveMaze(int[][] maze, int row, int col, boolean[][] visited, int[][] path) {
        int n = maze.length;
        int m = maze[0].length;

        if (!isSafe(maze, row, col, visited)) {
            return false;
        }

        visited[row][col] = true;
        path[row][col] = 1;

        if (row == n - 1 && col == m - 1) {
            return true;
        }

        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (solveMaze(maze, nextRow, nextCol, visited, path)) {
                return true;
            }
        }

        path[row][col] = 0;
        visited[row][col] = false;
        return false;
    }

    private static boolean isSafe(int[][] maze, int row, int col, boolean[][] visited) {
        int n = maze.length;
        int m = maze[0].length;

        return row >= 0 && row < n && col >= 0 && col < m
                && maze[row][col] == 1 && !visited[row][col];
    }

    private static void printPath(int[][] path) {
        for (int[] row : path) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
