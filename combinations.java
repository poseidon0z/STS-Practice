import java.util.ArrayList;
import java.util.Scanner;

public class combinations {
    private static void printCombinations(int[] arr, ArrayList<Integer> data, int start, int r) {
        if (data.size() == r) {
            System.out.println(data.toString());
        }

        for (int i = start; i < arr.length; i++) {
            data.add(arr[i]);
            printCombinations(arr, data, i + 1, r);
            data.removeLast();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Give the number of elements: ");
        int n = in.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            printCombinations(arr, data, 0, i);
        }
        in.close();
    }
}
