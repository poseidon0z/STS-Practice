import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class KnightsTourGUI extends JPanel {
    private static final int CELL_SIZE = 50; // Size of each cell in pixels
    private int[][] board;
    private int boardSize;

    public KnightsTourGUI(int size) {
        this.boardSize = size;
        this.board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = -1;
            }
        }
        setPreferredSize(new Dimension(size * CELL_SIZE, size * CELL_SIZE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                // Alternate cell color
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.LIGHT_GRAY);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);

                // Draw green color for visited cells
                if (board[i][j] >= 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }

                // Draw grid and move numbers
                g.setColor(Color.BLACK);
                g.drawRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);

                if (board[i][j] >= 0) {
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(board[i][j]), j * CELL_SIZE + CELL_SIZE / 2 - 5,
                            i * CELL_SIZE + CELL_SIZE / 2 + 5);
                }
            }
        }
    }

    public void updateBoard(int row, int col, int move) {
        board[row][col] = move;
        repaint();
        try {
            TimeUnit.MILLISECONDS.sleep(300); // Delay for visualization
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValid(int row, int col, int[][] board) {
        int N = board.length;
        return row >= 0 && row < N && col >= 0 && col < N && board[row][col] == -1;
    }

    private static int degree(int[][] board, int row, int col) {
        int[][] actions = { { 1, 2 }, { 2, 1 }, { -1, 2 }, { -2, 1 }, { -1, -2 }, { -2, -1 }, { 1, -2 }, { 2, -1 } };
        int count = 0;
        for (int[] action : actions) {
            int nr = row + action[0];
            int nc = col + action[1];
            if (isValid(nr, nc, board)) {
                count++;
            }
        }
        return count;
    }

    private static boolean solveTour(int row, int col, int moves, int[][] board, KnightsTourGUI gui) {
        int N = board.length;

        if (moves == N * N - 1) {
            return true;
        }

        int[][] actions = { { 1, 2 }, { 2, 1 }, { -1, 2 }, { -2, 1 }, { -1, -2 }, { -2, -1 }, { 1, -2 }, { 2, -1 } };
        int min_deg = Integer.MAX_VALUE, min_row = -1, min_col = -1;

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
        gui.updateBoard(min_row, min_col, moves + 1);

        if (solveTour(min_row, min_col, moves + 1, board, gui)) {
            return true;
        }

        board[min_row][min_col] = -1;
        gui.updateBoard(min_row, min_col, -1);
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of the board: ");
        int N = in.nextInt();

        System.out.print("Enter the starting coordinates: ");
        int px = in.nextInt();
        int py = in.nextInt();

        if (px < 0 || px >= N || py < 0 || py >= N) {
            System.out.println("Invalid starting coordinates. Exiting.");
            return;
        }

        JFrame frame = new JFrame("Knight's Tour Visualization");
        KnightsTourGUI gui = new KnightsTourGUI(N);
        frame.add(gui);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        board[px][py] = 0;
        gui.updateBoard(px, py, 0);

        boolean solved = solveTour(px, py, 0, board, gui);

        if (!solved) {
            System.out.println("No solution exists for the given starting position.");
        }

        in.close();
    }
}
