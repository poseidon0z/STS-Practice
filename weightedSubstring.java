import java.util.HashSet;
import java.util.Scanner;

public class weightedSubstring {
    private static int getWeightedSubstrings(String p, String q, int k) {
        HashSet<String> h = new HashSet<>();

        for (int i = 0; i < p.length(); i++) {
            String current = "";
            int cost = 0;

            for (int j = i; j < p.length(); j++) {
                current += p.charAt(j);
                cost += q.charAt(p.charAt(j) - 'a') - '0';

                if (cost <= k) {
                    System.out.println(current);
                    h.add(current);
                } else {
                    break;
                }
            }
        }

        return h.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String p = in.nextLine();

        System.out.print("Enter the weights: ");
        String q = in.nextLine();

        System.out.print("Enter the max substring weight: ");
        int k = in.nextInt();

        System.out.println("Strings is: " + getWeightedSubstrings(p, q, k));

        in.close();
    }
}
