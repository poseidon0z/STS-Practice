import java.util.Scanner;

public class maxProdSubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = in.nextInt();

        int temp = in.nextInt();
        int max_ending_here = temp;
        int min_ending_here = temp;
        int max_so_far = temp;
        for (int i = 1; i < size; i++) {
            temp = in.nextInt();
            max_ending_here = Math.max(max_ending_here * temp, Math.max(temp, min_ending_here * temp));
            min_ending_here = Math.min(max_ending_here * temp, Math.min(temp, min_ending_here * temp));
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        System.out.println("Max product is: " + max_so_far);
        in.close();
    }
}
