import java.util.Scanner;

public class josephusProblem {
    private static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        }

        return (josephus(n - 1, k) + k - 1) % n + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of people: ");
        int n = in.nextInt();

        System.out.print("Enter the number of people skipped: ");
        int k = in.nextInt();

        System.out.println("You should stand at position " + josephus(n, k));
        in.close();
    }
}
