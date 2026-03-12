import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensOptimized {
    public static void main(String[] args) {
        int n = 8;

        int[] oneSolution = solveOneSolution(n);
        if (oneSolution != null) {
            System.out.println("One solution for N=" + n + ": " + Arrays.toString(oneSolution));
            printBoard(oneSolution);
        } else {
            System.out.println("No solution exists for N=" + n);
        }

        int[][] forbidden = new int[n][n];
        forbidden[0][0] = 1;
        forbidden[1][2] = 1;

        int[] withForbidden = solveOneSolutionWithForbidden(n, forbidden);
        if (withForbidden != null) {
            System.out.println("One solution with forbidden squares: " + Arrays.toString(withForbidden));
        } else {
            System.out.println("No solution with given forbidden squares.");
        }

        int n4 = 4;
        List<int[]> allForN4 = solveAllSolutions(n4);
        System.out.println("Total solutions for N=" + n4 + ": " + allForN4.size());
        for (int i = 0; i < allForN4.size(); i++) {
            System.out.println("Solution " + (i + 1) + ": " + Arrays.toString(allForN4.get(i)));
        }
    }

    public static int[] solveOneSolution(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        boolean[] usedColumns = new boolean[n];
        boolean[] usedDiag1 = new boolean[2 * n - 1];
        boolean[] usedDiag2 = new boolean[2 * n - 1];

        boolean found = placeOne(0, n, queens, usedColumns, usedDiag1, usedDiag2);
        return found ? queens : null;
    }

    public static List<int[]> solveAllSolutions(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        boolean[] usedColumns = new boolean[n];
        boolean[] usedDiag1 = new boolean[2 * n - 1];
        boolean[] usedDiag2 = new boolean[2 * n - 1];

        List<int[]> solutions = new ArrayList<>();
        placeAll(0, n, queens, usedColumns, usedDiag1, usedDiag2, solutions);
        return solutions;
    }

    public static int[] solveOneSolutionWithForbidden(int n, int[][] forbidden) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        boolean[] usedColumns = new boolean[n];
        boolean[] usedDiag1 = new boolean[2 * n - 1];
        boolean[] usedDiag2 = new boolean[2 * n - 1];

        boolean found = placeOneWithForbidden(0, n, queens, usedColumns, usedDiag1, usedDiag2, forbidden);
        return found ? queens : null;
    }

    private static boolean placeOne(int row, int n, int[] queens, boolean[] usedColumns,
                                    boolean[] usedDiag1, boolean[] usedDiag2) {
        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            int diag1 = row - col + (n - 1);
            int diag2 = row + col;

            if (usedColumns[col] || usedDiag1[diag1] || usedDiag2[diag2]) {
                continue;
            }

            queens[row] = col;
            usedColumns[col] = true;
            usedDiag1[diag1] = true;
            usedDiag2[diag2] = true;

            if (placeOne(row + 1, n, queens, usedColumns, usedDiag1, usedDiag2)) {
                return true;
            }

            queens[row] = -1;
            usedColumns[col] = false;
            usedDiag1[diag1] = false;
            usedDiag2[diag2] = false;
        }

        return false;
    }

    private static void placeAll(int row, int n, int[] queens, boolean[] usedColumns,
                                 boolean[] usedDiag1, boolean[] usedDiag2, List<int[]> solutions) {
        if (row == n) {
            solutions.add(Arrays.copyOf(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            int diag1 = row - col + (n - 1);
            int diag2 = row + col;

            if (usedColumns[col] || usedDiag1[diag1] || usedDiag2[diag2]) {
                continue;
            }

            queens[row] = col;
            usedColumns[col] = true;
            usedDiag1[diag1] = true;
            usedDiag2[diag2] = true;

            placeAll(row + 1, n, queens, usedColumns, usedDiag1, usedDiag2, solutions);

            queens[row] = -1;
            usedColumns[col] = false;
            usedDiag1[diag1] = false;
            usedDiag2[diag2] = false;
        }
    }

    private static boolean placeOneWithForbidden(int row, int n, int[] queens, boolean[] usedColumns,
                                                 boolean[] usedDiag1, boolean[] usedDiag2, int[][] forbidden) {
        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (forbidden[row][col] == 1) {
                continue;
            }

            int diag1 = row - col + (n - 1);
            int diag2 = row + col;

            if (usedColumns[col] || usedDiag1[diag1] || usedDiag2[diag2]) {
                continue;
            }

            queens[row] = col;
            usedColumns[col] = true;
            usedDiag1[diag1] = true;
            usedDiag2[diag2] = true;

            if (placeOneWithForbidden(row + 1, n, queens, usedColumns, usedDiag1, usedDiag2, forbidden)) {
                return true;
            }

            queens[row] = -1;
            usedColumns[col] = false;
            usedDiag1[diag1] = false;
            usedDiag2[diag2] = false;
        }

        return false;
    }

    private static void printBoard(int[] queens) {
        int n = queens.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (queens[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
