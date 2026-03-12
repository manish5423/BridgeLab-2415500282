import java.util.ArrayList;
import java.util.List;

public class WordPuzzleBacktracking {
    private static final int[][] DIRECTIONS_8 = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
    };

    public static void main(String[] args) {
        char[][] grid = {
                {'C', 'A', 'T', 'S'},
                {'O', 'R', 'E', 'A'},
                {'D', 'E', 'A', 'M'},
                {'E', 'L', 'L', 'S'}
        };

        String targetWord = "DREAM";

        List<List<String>> allPaths = findAllPaths(grid, targetWord);
        System.out.println("Can form word: " + !allPaths.isEmpty());
        System.out.println("Total ways: " + allPaths.size());

        for (int i = 0; i < allPaths.size(); i++) {
            System.out.println("Path " + (i + 1) + ": " + allPaths.get(i));
        }
    }

    public static List<List<String>> findAllPaths(char[][] grid, String word) {
        List<List<String>> result = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][cols];
                    List<String> currentPath = new ArrayList<>();
                    backtrack(grid, word, row, col, 0, visited, currentPath, result);
                }
            }
        }

        return result;
    }

    private static void backtrack(char[][] grid, String word, int row, int col, int index,
                                  boolean[][] visited, List<String> currentPath,
                                  List<List<String>> result) {
        if (index == word.length()) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        if (visited[row][col] || grid[row][col] != word.charAt(index)) {
            return;
        }

        visited[row][col] = true;
        currentPath.add("(" + row + "," + col + ")");

        for (int[] direction : DIRECTIONS_8) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            backtrack(grid, word, nextRow, nextCol, index + 1, visited, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1);
        visited[row][col] = false;
    }
}
