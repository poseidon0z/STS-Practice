import java.util.Scanner;

public class maneuveringProblem {
    private static int pathCount(int n, int m) {
        int dp[] = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of row and columns: ");
        int n = in.nextInt();
        int m = in.nextInt();

        System.out.println(pathCount(n, m));
        in.close();
    }
}
