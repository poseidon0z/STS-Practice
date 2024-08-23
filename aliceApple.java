import java.util.Scanner;

public class aliceApple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of red apples needed: ");
        int M = in.nextInt();
        System.out.print("Enter the number of apples per tree: ");
        int K = in.nextInt();
        System.out.print("Enter the number of trees in north: ");
        int N = in.nextInt();
        System.out.print("Enter the number of trees in east: ");
        int E = in.nextInt();
        System.out.print("Enter the number of trees in south: ");
        int S = in.nextInt();
        System.out.print("Enter the number of trees in west: ");
        int W = in.nextInt();

        if (M <= S * K) {
            System.out.println(M);
        } else if (M <= S * K + W + E) {
            System.out.println(S * K + (M - S * K) * K);
        } else {
            System.out.println(-1);
        }

        in.close();
    }
}
