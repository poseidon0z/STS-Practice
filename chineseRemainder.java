import java.util.Scanner;

public class chineseRemainder {
    static int findRem(int a[], int m[], int n) {
        int answer = 0;

        int M = 1;
        for (int i = 0; i < n; i++) {
            M *= m[i];
        }

        for (int i = 0; i < n; i++) {
            int Mi = M / m[i];
            int Minv = 0;
            for (int j = 0; j < m[i]; j++) {
                if ((Mi * j) % m[i] == 1) {
                    Minv = j;
                    break;
                }
            }

            answer += a[i] * Mi * Minv;
        }

        return answer % M;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of things: ");
        int num = in.nextInt();
        int m[] = new int[num];
        int a[] = new int[num];

        System.out.println("m values (moduli): ");
        for (int i = 0; i < num; i++) {
            m[i] = in.nextInt();
        }

        System.out.println("a values (remainders): ");
        for (int i = 0; i < num; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(findRem(a, m, num));
        in.close();
    }
}
