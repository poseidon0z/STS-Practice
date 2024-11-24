import java.util.Scanner;

public class nQueens {

    private static boolean check(int[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] != 0) {
                return false;
            }

            if (board[x][i] != 0) {
                return false;
            }

            if (x - i >= 0 && y - i >= 0 && board[x - i][y - i] != 0) {
                return false;
            }

            if (x + i < board.length && y + i < board.length && board[x + i][y + i] != 0) {
                return false;
            }

            if (x - i >= 0 && y + i < board.length && board[x - i][y + i] != 0) {
                return false;
            }

            if (x + i < board.length && y - i >= 0 && board[x + i][y - i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean queens(int n, int[][] board) {
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0 && check(board, i, j)) {
                    board[i][j] = 1;
                    if (queens(n - 1, board)) {
                        return true;
                    }
                    board[i][j] = 0;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of queens: ");
        int n = in.nextInt();

        int[][] board = new int[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }

        if (queens(n, board)) {

            for (int[] i : board) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solutions found!");
        }
        in.close();
    }
}
