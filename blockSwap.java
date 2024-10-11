import java.util.Scanner;

public class blockSwap {
    static void swap(int arr[], int a, int b, int k) {
        for (int i = 0; i < k; i++) {
            int temp = arr[a + i];
            arr[a + i] = arr[b + i];
            arr[b + i] = temp;
        }
    }

    static void blockSwapper(int arr[], int i, int d, int n) {
        if (d == 0 || d == n) {
            return;
        }

        if (n - d == d) {
            swap(arr, i, n - d + i, d);
            return;
        }

        else if (d < n - d) {
            swap(arr, i, n - d + i, d);
            blockSwapper(arr, i, d, n - d);
        } else {
            swap(arr, i, d, n - d);
            blockSwapper(arr, n - d + i, 2 * d - n, d);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = in.nextInt();

        int vals[] = new int[size];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            vals[i] = in.nextInt();
        }

        System.out.println("Enter the amount to rotate the array: ");
        int rotate = in.nextInt() % size;

        blockSwapper(vals, 0, rotate, size);

        for (int val : vals) {
            System.out.print(val + " ");
        }
        in.close();
    }
}
