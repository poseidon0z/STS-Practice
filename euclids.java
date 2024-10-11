import java.util.Scanner;

public class euclids {
    static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int first = in.nextInt();

        System.out.print("Enter the second number: ");
        int second = in.nextInt();

        System.out.println(gcd(first, second));
        in.close();
    }
}
