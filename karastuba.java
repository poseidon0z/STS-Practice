import java.util.Scanner;

public class karastuba {
    static int karastubaMultiply(int a, int b) {
        if (a < 10 || b < 10) {
            return a * b;
        }

        int digits = (int) Math.max(Math.log10(a) + 1, Math.log10(b) + 1);
        int half_digits = digits / 2;
        int power_10 = (int) Math.pow(10, half_digits);

        int x = a / power_10;
        int y = a % power_10;
        int u = b / power_10;
        int v = b % power_10;

        int s1 = karastubaMultiply(x, u);
        int s2 = karastubaMultiply(y, v);
        int s3 = karastubaMultiply(x + y, u + v);
        return s1 * (int) Math.pow(10, digits) + (s3 - s2 - s1) * power_10 + s2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int first = in.nextInt();

        System.out.print("Enter the second number: ");
        int second = in.nextInt();

        System.out.println(karastubaMultiply(first, second));
        in.close();
    }
}
