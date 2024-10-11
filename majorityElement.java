import java.util.Scanner;
import java.util.HashMap;

public class majorityElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> counts = new HashMap<>();

        System.out.print("Enter the number of elements in the array: ");
        int n = in.nextInt();

        System.out.print("Enter the values: ");
        int majority = -1;
        for (int i = 0; i < n; i++) {
            Integer temp = in.nextInt();
            counts.get(temp);

            counts.putIfAbsent(temp, 0);
            int total = counts.get(temp) + 1;
            counts.put(temp, total);
            if (total > n / 2) {
                majority = temp;
                break;
            }
        }

        System.out.println("Majority element is: " + majority);

        in.close();
    }
}
