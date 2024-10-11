import java.util.Scanner;

public class maxHourglass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = in.nextInt();

        System.out.print("Enter the number of cols: ");
        int cols = in.nextInt();

        int mat[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = in.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int sum = mat[i][j] + mat[i][j + 1] + mat[i][j + 2] + mat[i + 1][j + 1] + mat[i + 2][j]
                        + mat[i + 2][j + 1] + mat[i + 2][j + 2];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        System.out.println("max sum is: " + max);
        in.close();
    }
}
