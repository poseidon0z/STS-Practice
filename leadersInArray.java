import java.util.Scanner;

public class leadersInArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = in.nextInt();

        System.out.print("Enter the vals: ");
        int vals[] = new int[size];

        for (int i = 0; i < size; i++) {
            vals[i] = in.nextInt();
        }

        int max = -1;
        System.out.print("Leaders are: ");
        for (int i = size - 1; i >= 0; i--) {
            if (vals[i] > max) {
                System.out.print(vals[i] + " ");
                max = vals[i];
            }
        }
        in.close();
    }
}
