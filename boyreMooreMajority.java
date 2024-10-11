import java.util.Scanner;

public class boyreMooreMajority {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = in.nextInt();
        int temp;

        System.out.print("Enter the array elements: ");
        int majority = in.nextInt();
        int count = 1;

        for (int i = 1; i < size; i++) {
            temp = in.nextInt();
            if (temp != majority) {
                count--;
                if (count == 0) {
                    majority = temp;
                    count = 1;
                }
            } else {
                count++;
            }
        }

        System.out.println("The majority element is: " + majority);

        in.close();
    }
}
