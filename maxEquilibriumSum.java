import java.util.Scanner;

public class maxEquilibriumSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = in.nextInt();

        int vals[] = new int[size];
        int right_sum = 0;
        System.out.print("Enter the values of the array: ");
        for (int i = 0; i < size; i++) {
            vals[i] = in.nextInt();
            right_sum += vals[i];
        }

        int min_cost = right_sum;
        int left_sum = 0;
        int equi = 0;
        for (int i = 0; i < size; i++) {
            left_sum += vals[i];
            right_sum -= vals[i];

            if (Math.abs(left_sum - right_sum) < min_cost) {
                min_cost = Math.abs(left_sum - right_sum);
                equi = i;
            }
        }

        System.out.println(
                "The equilibrium point is: " + equi);
        in.close();
    }
}
