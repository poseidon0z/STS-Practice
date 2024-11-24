import java.util.Scanner;
import java.lang.Thread;

public class knightsTour {
    static int[][] actions = { { 1, 2 }, { 2, 1 }, { -1, 2 }, { -2, 1 }, { -1, -2 }, { -2, -1 }, { 1, -2 }, { 2, -1 } };

    private static boolean isValid(int row, int col, int[][] board) {
        int N = board.length;
        if (row >= N || row < 0 || col >= N || col < 0 || board[row][col] != -1) {
            return false;
        }

        return true;
    }

    private static int degree(int[][] board, int row, int col) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nr = row + actions[i][0];
            int nc = col + actions[i][1];
            if (isValid(nr, nc, board)) {
                count++;
            }
        }
        return count;
    }

    private static boolean solveTour(int row, int col, int moves, int[][] board) {
        int N = board.length;

        if (moves == N * N - 1) {
            return true;
        }

        int min_deg = 999, min_row = -1, min_col = -1;
        for (int[] action : actions) {
            int newRow = row + action[0];
            int newCol = col + action[1];

            if (isValid(newRow, newCol, board)) {
                int newDeg = degree(board, newRow, newCol);
                if (newDeg < min_deg) {
                    min_deg = newDeg;
                    min_row = newRow;
                    min_col = newCol;
                }
            }
        }

        if (min_row == -1) {
            return false;
        }

        board[min_row][min_col] = moves + 1;
        if (solveTour(min_row, min_col, moves + 1, board)) {
            return true;
        }
        board[min_row][min_col] = -1;

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of board: ");
        int N = in.nextInt();

        int board[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        System.out.print("Enter the starting coordinates: ");
        int px = in.nextInt();
        int py = in.nextInt();

        board[px][py] = 0;

        boolean solved = solveTour(px, py, 0, board);

        if (solved) {
            for (int[] i : board) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
        in.close();
    }
}
